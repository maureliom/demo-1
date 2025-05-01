package com.example.demo.service;

import com.example.demo.config.PojoGeneratorProperties;
import com.example.demo.generator.EnumFieldGenerator;
import com.example.demo.generator.EnumGenerator;
import com.example.demo.generator.FieldBuilder;
import com.example.demo.generator.PojoField;
import com.example.demo.generator.PojoGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchemaProcessorService {

    private final PojoGeneratorProperties properties;

    @Autowired
    private Configuration freemarker;

    private final Set<String> generatedClassNames = new HashSet<>();

    public void run() {
        File schemaDir = new File(properties.getSchemaDirectory());

        if (!schemaDir.exists() || !schemaDir.isDirectory()) {
            throw new IllegalArgumentException("Invalid schema directory: " + schemaDir.getAbsolutePath());
        }

        File[] schemaFiles = schemaDir.listFiles((dir, name) -> name.endsWith(".json"));
        if (schemaFiles == null || schemaFiles.length == 0) {
            throw new IllegalStateException("No schema files found in directory: " + schemaDir.getAbsolutePath());
        }

        log.info("Found {} schema files. Beginning processing...", schemaFiles.length);

        for (File schemaFile : schemaFiles) {
            try {
                processSchema(schemaFile);
            } catch (Exception e) {
                log.error("Error processing schema: {}", schemaFile.getName(), e);
                if (properties.isTreatWarningsAsErrors()) {
                    throw new RuntimeException("Treating warning as error: " + e.getMessage(), e);
                }
            }
        }

        if (properties.isDryRunMode()) {
            log.info("\u2705 Dry-run completed — all {} schema files passed validation.", schemaFiles.length);
        } else {
            log.info("\u2705 POJO generation complete — {} schema files processed.", schemaFiles.length);
        }
    }

    private void processSchema(File schemaFile) throws Exception {
        log.info("Validating schema: {}", schemaFile.getName());
        SchemaParser parser = new SchemaParser();
        parser.validateSchema(schemaFile);

        if (properties.isDryRunMode()) {
            log.info("Dry-run mode active. Skipping POJO generation for: {}", schemaFile.getName());
            return;
        }

        String className = deriveClassName(schemaFile);
        String subPackage = deriveSubPackage(schemaFile);
        String fullPackage = "com.example.demo.model.ocpp.schema." + subPackage;
        String outputDir = "src/main/java/" + fullPackage.replace('.', '/');

        ObjectMapper mapper = new ObjectMapper();
        JsonNode schema = mapper.readTree(schemaFile);
        JsonNode propsNode = schema.get("properties");
        JsonNode definitions = schema.get("definitions");

        Set<String> requiredFields = extractRequiredFields(schema);
        Map<String, String> typeMap = buildTypeMap(definitions, className);

        List<PojoField> fields = buildPojoFields(propsNode, requiredFields, typeMap);

        generateEnums(propsNode, fullPackage, outputDir);

        File outputFile = new File(outputDir, className + ".java");
        new PojoGenerator(freemarker).generatePojo(fullPackage, className, "Generated from schema", fields, outputFile, schema);

        Set<String> allRefDefs = new HashSet<>();
        collectAllRefs(schema, allRefDefs);

        if (definitions != null) {
            for (String refName : allRefDefs) {
                JsonNode typeNode = definitions.get(refName);
                if (typeNode == null || !typeNode.has("type")) continue;

                if (typeNode.has("enum")) {
                    String enumName = typeNode.has("javaType") ? typeNode.get("javaType").asText() : toUpperCamelCase(refName);
                    EnumFieldGenerator.EnumSpec spec = EnumFieldGenerator.generateEnum(enumName, typeNode);
                    File enumFile = new File(outputDir, enumName + ".java");
                    new EnumGenerator(freemarker).generateEnum(fullPackage, spec, enumFile);
                    continue;
                }

                Set<String> defRequired = extractRequiredFields(typeNode);
                List<PojoField> defFields = buildPojoFields(typeNode.get("properties"), defRequired, typeMap);
                String defClassName = typeMap.getOrDefault(refName, toUpperCamelCase(refName.replace("Type", "")));
                File defFile = new File(outputDir, defClassName + ".java");
                new PojoGenerator(freemarker).generatePojo(fullPackage, defClassName, "Generated from definition", defFields, defFile, typeNode);
                log.info("Generated definition POJO: {}", defFile.getName());
            }
        }
    }

    private Map<String, String> buildTypeMap(JsonNode definitions, String contextName) {
        Map<String, String> typeMap = new HashMap<>();
        if (definitions != null) {
            definitions.fields().forEachRemaining(entry -> {
                String key = entry.getKey();
                JsonNode def = entry.getValue();
                String javaType = def.has("javaType") ? def.get("javaType").asText() : toUpperCamelCase(key.replace("Type", ""));
                typeMap.put(key, javaType);
            });
        }
        return typeMap;
    }

    private List<PojoField> buildPojoFields(JsonNode propsNode, Set<String> requiredFields, Map<String, String> typeMap) {
        List<PojoField> fields = new ArrayList<>();
        if (propsNode != null) {
            propsNode.fields().forEachRemaining(entry -> {
                String propName = entry.getKey();
                JsonNode propNode = entry.getValue();
                fields.add(FieldBuilder.fromSchema(propName, propNode, requiredFields, typeMap));
            });
        }
        return fields;
    }

    private Set<String> extractRequiredFields(JsonNode node) {
        Set<String> requiredFields = new HashSet<>();
        JsonNode requiredNode = node.get("required");
        if (requiredNode != null && requiredNode.isArray()) {
            for (JsonNode r : requiredNode) requiredFields.add(r.asText());
        }
        return requiredFields;
    }

    private void generateEnums(JsonNode propsNode, String fullPackage, String outputDir) throws Exception {
        if (propsNode != null) {
            for (Iterator<Map.Entry<String, JsonNode>> it = propsNode.fields(); it.hasNext();) {
                Map.Entry<String, JsonNode> entry = it.next();
                String name = entry.getKey();
                JsonNode value = entry.getValue();

                if (value.has("enum")) {
                    String enumName = toUpperCamelCase(name) + "Enum";
                    EnumFieldGenerator.EnumSpec spec = EnumFieldGenerator.generateEnum(enumName, value);
                    File enumFile = new File(outputDir, enumName + ".java");
                    new EnumGenerator(freemarker).generateEnum(fullPackage, spec, enumFile);
                    log.info("Generated enum: {}", enumFile.getAbsolutePath());
                }
            }
        }
    }

    private void collectAllRefs(JsonNode node, Set<String> refs) {
        if (node == null) return;

        if (node.isObject()) {
            node.fields().forEachRemaining(entry -> {
                String key = entry.getKey();
                JsonNode value = entry.getValue();

                if ("$ref".equals(key) && value.isTextual()) {
                    String ref = value.asText();
                    if (ref.contains("#/definitions/")) {
                        refs.add(ref.substring(ref.lastIndexOf("/") + 1));
                    }
                } else {
                    collectAllRefs(value, refs);
                }
            });
        } else if (node.isArray()) {
            for (JsonNode item : node) {
                collectAllRefs(item, refs);
            }
        }
    }

    private String deriveClassName(File schemaFile) {
        String name = schemaFile.getName();
        return toUpperCamelCase(name.replace(".json", ""));
    }

    private String deriveSubPackage(File schemaFile) {
        return schemaFile.getName()
            .replace(".json", "")
            .replaceAll("([a-z])([A-Z])", "$1_$2")
            .toLowerCase();
    }

    private String toUpperCamelCase(String input) {
        return Arrays.stream(input.split("[^a-zA-Z0-9]"))
            .filter(s -> !s.isEmpty())
            .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
            .collect(Collectors.joining());
    }
}