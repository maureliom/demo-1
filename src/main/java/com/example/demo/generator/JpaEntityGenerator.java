package com.example.demo.generator;

import com.fasterxml.jackson.databind.JsonNode;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

@Slf4j
public class JpaEntityGenerator {

    private final Configuration freemarker;
    Map<String, Integer> occurrences;

    public JpaEntityGenerator(Configuration freemarker, Map<String, Integer> occurrences) {
        this.freemarker = freemarker;
        this.occurrences = occurrences;
    }

    public void generateEntity(JsonNode schema, String packageName, String className, String outputDir) throws Exception {
        String repositoryPackage = packageName.replace("model", "repository");
        String repositoryOutputDir = outputDir.replace("model", "repository");
        JsonNode definitions = schema.get("definitions");
        
        generateEntityFromSchema(schema, packageName, className, outputDir, repositoryPackage, repositoryOutputDir);

        
        if (definitions != null) {
            Map<String, String> typeMap = new HashMap<>();
            typeMap.put("__rootClass", className);

            // First collect all types
            definitions.fields().forEachRemaining(entry -> {
                String defKey = entry.getKey();
                JsonNode defNode = entry.getValue();
                String defClass = defNode.has("javaType")
                    ? defNode.get("javaType").asText()
                    : toUpperCamelCase(defKey.replace("Type", ""));
                
                
                if (occurrences.getOrDefault(defKey, 0) > 1) {
                    defClass += className;
                }
                
                typeMap.put(defKey, defClass);
            });

            // Now generate entities and enums
            definitions.fields().forEachRemaining(entry -> {
                String defKey = entry.getKey();
                JsonNode defNode = entry.getValue();
                String defClass = typeMap.get(defKey);

                boolean isenum = false;
                if (defNode.toString().contains("Enum")) {
                	isenum = true;
                }         
                
                if (defNode.has("enum")) {
                    generateEnum(packageName, defClass, defNode, outputDir);
                } else {
                    try {
                    	log.info("gerou entity pelo Entity Generator");
                        generateEntityFromDefinition(isenum, defNode, packageName, defClass, outputDir, typeMap, repositoryPackage, repositoryOutputDir, occurrences );
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to generate entity for definition: " + defKey, e);
                    }
                }
            });
        }
    }


    private void generateEntityFromSchema(JsonNode schema, String packageName, String className, String outputDir, String repoPackage, String repoOutputDir) throws Exception {
        JsonNode propsNode = schema.get("properties");
        Set<String> requiredFields = extractRequiredFields(schema);
        Map<String, String> typeMap = extractTypeMap(schema);
        typeMap.put("__rootClass", className);

        
        List<PojoField> fields = new ArrayList<>();
        if (propsNode != null) {
            propsNode.fields().forEachRemaining(entry -> {
                String name = entry.getKey();
                JsonNode value = entry.getValue();

                String defKey = entry.getKey();
                JsonNode testNode = entry.getValue();
                String defClass = typeMap.get(defKey);
                
                boolean isenum = false;
                if (value.toString().contains("Enum")) {
                	isenum = true;
                }
                		
                log.info("Log fromSchema\n");
                log.info("name "+name+"\n"+
                		" value "+value+"\n"+
                		" defKey "+defKey+"\n"+
                		" testNode "+testNode+"\n"+
                		" defClass "+defClass+"\n");  
                
                fields.add(JpaFieldBuilder.fromSchema(isenum, name, value, requiredFields, typeMap, occurrences));
                if (value.has("enum")) {
                	log.info("gerou ENUM pelo FromSchema");
                    generateEnum(packageName, name, value, outputDir);
                }
            });
        }

        writeJpaEntity(packageName, className, outputDir, schema.path("description").asText(null), fields);
        new JpaRepositoryGenerator(freemarker).generateRepository(repoPackage, className, repoOutputDir);
    }

    private void generateEntityFromDefinition(boolean isEnum, JsonNode defNode, String packageName, String className, String outputDir, Map<String, String> typeMap, String repoPackage, String repoOutputDir, Map<String, Integer> occurrences) throws Exception {
        JsonNode propsNode = defNode.get("properties");
        Set<String> requiredFields = extractRequiredFields(defNode);

        List<PojoField> fields = new ArrayList<>();
        if (propsNode != null) {
            propsNode.fields().forEachRemaining(entry -> {
                String name = entry.getKey();
                JsonNode value = entry.getValue();
                
                String defKey = entry.getKey();
                JsonNode testNode = entry.getValue();
                String defClass = typeMap.get(defKey);
                
                log.info("Log definition\n");                
                log.info("name "+name+"\n"+
                		" value "+value+"\n"+
                		" defKey "+defKey+"\n"+
                		" testNode "+testNode+"\n"+
                		" defClass "+defClass+"\n");                
                
                fields.add(JpaFieldBuilder.fromSchema(isEnum, name, value, requiredFields, typeMap, occurrences));
//                if (value.has("enum")) {
//                	log.info("gerou ENUM pelo FromDefinition");
//                    generateEnum(packageName, name, value, outputDir);
//                }
            });
        }

        String resolvedClassName = occurrences.getOrDefault(className, 0) > 1
        	    ? className + typeMap.getOrDefault("__rootClass", "")
        	    : className;

        	writeJpaEntity(packageName, resolvedClassName, outputDir, defNode.path("description").asText(null), fields);
        	new JpaRepositoryGenerator(freemarker).generateRepository(
        	    packageName.replace("model", "repository"), resolvedClassName, outputDir.replace("model", "repository")
        	);       	
        	
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
