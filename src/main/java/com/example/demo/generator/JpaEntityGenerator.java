package com.example.demo.generator;

import com.fasterxml.jackson.databind.JsonNode;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

public class JpaEntityGenerator {

    private final Configuration freemarker;

    public JpaEntityGenerator(Configuration freemarker) {
        this.freemarker = freemarker;
    }

    public void generateEntity(JsonNode schema, String packageName, String className, String outputDir) throws Exception {
        String repositoryPackage = packageName.replace("model", "repository");
        String repositoryOutputDir = outputDir.replace("model", "repository");

        generateEntityFromSchema(schema, packageName, className, outputDir, repositoryPackage, repositoryOutputDir);

        JsonNode definitions = schema.get("definitions");
        if (definitions != null) {
            Map<String, String> typeMap = new HashMap<>();
            definitions.fields().forEachRemaining(entry -> {
                String defKey = entry.getKey();
                JsonNode def = entry.getValue();
                String javaType = def.has("javaType") ? def.get("javaType").asText() : toUpperCamelCase(defKey.replace("Type", ""));
                typeMap.put(defKey, javaType);
            });

            for (Map.Entry<String, String> entry : typeMap.entrySet()) {
                String defKey = entry.getKey();
                String defClass = entry.getValue();
                JsonNode defNode = definitions.get(defKey);

                if (defNode.has("enum")) {
                    generateEnum(packageName, defNode.has("javaType") ? defNode.get("javaType").asText() : defKey, defNode, outputDir);
                    continue;
                }

                generateEntityFromDefinition(defNode, packageName, defClass, outputDir, typeMap, repositoryPackage, repositoryOutputDir);
            }
        }
    }

    private void generateEntityFromSchema(JsonNode schema, String packageName, String className, String outputDir, String repoPackage, String repoOutputDir) throws Exception {
        JsonNode propsNode = schema.get("properties");
        Set<String> requiredFields = extractRequiredFields(schema);
        Map<String, String> typeMap = extractTypeMap(schema);

        List<PojoField> fields = new ArrayList<>();
        if (propsNode != null) {
            propsNode.fields().forEachRemaining(entry -> {
                String name = entry.getKey();
                JsonNode value = entry.getValue();
                fields.add(JpaFieldBuilder.fromSchema(name, value, requiredFields, typeMap));
                if (value.has("enum")) {
                    generateEnum(packageName, name, value, outputDir);
                }
            });
        }

        writeJpaEntity(packageName, className, outputDir, schema.path("description").asText(null), fields);
        new JpaRepositoryGenerator(freemarker).generateRepository(repoPackage, className, repoOutputDir);
    }

    private void generateEntityFromDefinition(JsonNode defNode, String packageName, String className, String outputDir, Map<String, String> typeMap, String repoPackage, String repoOutputDir) throws Exception {
        JsonNode propsNode = defNode.get("properties");
        Set<String> requiredFields = extractRequiredFields(defNode);

        List<PojoField> fields = new ArrayList<>();
        if (propsNode != null) {
            propsNode.fields().forEachRemaining(entry -> {
                String name = entry.getKey();
                JsonNode value = entry.getValue();
                fields.add(JpaFieldBuilder.fromSchema(name, value, requiredFields, typeMap));
                if (value.has("enum")) {
                    generateEnum(packageName, name, value, outputDir);
                }
            });
        }

        writeJpaEntity(packageName, className, outputDir, defNode.path("description").asText(null), fields);
        new JpaRepositoryGenerator(freemarker).generateRepository(repoPackage, className, repoOutputDir);
    }

    private void generateEnum(String packageName, String fieldName, JsonNode value, String outputDir) {
        try {
            String enumName = toUpperCamelCase(fieldName);
            EnumFieldGenerator.EnumSpec spec = EnumFieldGenerator.generateEnum(enumName, value);
            File enumFile = new File(outputDir, enumName + ".java");
            new EnumGenerator(freemarker).generateEnum(packageName, spec, enumFile);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate enum for: " + fieldName, e);
        }
    }

    private void writeJpaEntity(String packageName, String className, String outputDir, String description, List<PojoField> fields) throws Exception {
        boolean usesList = fields.stream().anyMatch(f -> f.getType().contains("List<"));

        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("className", className);
        data.put("tableName", toSnakeCase(className));
        data.put("fields", fields);
        data.put("usesList", usesList);
        data.put("description", description);

        File outputFile = new File(outputDir, className + ".java");
        outputFile.getParentFile().mkdirs();

        Template template = freemarker.getTemplate("jpa_entity.ftl");
        try (Writer writer = new FileWriter(outputFile)) {
            template.process(data, writer);
        }
    }

    private Set<String> extractRequiredFields(JsonNode node) {
        Set<String> requiredFields = new HashSet<>();
        JsonNode requiredNode = node.get("required");
        if (requiredNode != null && requiredNode.isArray()) {
            for (JsonNode r : requiredNode) requiredFields.add(r.asText());
        }
        return requiredFields;
    }

    private Map<String, String> extractTypeMap(JsonNode schema) {
        Map<String, String> typeMap = new HashMap<>();
        JsonNode definitions = schema.get("definitions");
        if (definitions != null) {
            definitions.fields().forEachRemaining(entry -> {
                String defKey = entry.getKey();
                JsonNode def = entry.getValue();
                String javaType = def.has("javaType") ? def.get("javaType").asText() : toUpperCamelCase(defKey.replace("Type", ""));
                typeMap.put(defKey, javaType);
            });
        }
        return typeMap;
    }

    private String toUpperCamelCase(String s) {
        return Arrays.stream(s.split("[^a-zA-Z0-9]"))
                .filter(p -> !p.isEmpty())
                .map(p -> Character.toUpperCase(p.charAt(0)) + p.substring(1))
                .reduce("", String::concat);
    }

    private String toSnakeCase(String input) {
        return input.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }
}
