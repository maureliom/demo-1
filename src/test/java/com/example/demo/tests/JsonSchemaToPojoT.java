package com.example.demo.tests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonSchemaToPojoT {

    private static final Path INPUT_DIR = Paths.get("src/main/resources/schemas/json");
    private static final String BASE_OUTPUT_DIR = "src/main/java";
    private static final String BASE_PACKAGE_MODEL = "com.example.demo.model.ocpp.schema";
    private static final String BASE_PACKAGE_DTO = "com.example.demo.dto.ocpp.schema";
    private static final String BASE_PACKAGE_ENUM = "com.example.demo.model.ocpp.schema.enums";
    private static final String BASE_PACKAGE_REPOSITORY = "com.example.demo.repository.ocpp.schema";
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public void generateAllFromSchemas() throws IOException {
        Files.walk(INPUT_DIR)
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".json"))
                .forEach(this::processSchema);
    }

    private void processSchema(Path path) {
        try {
            JsonNode root = mapper.readTree(path.toFile());
            String rootClassName = extractRootClassName(root.get("$id").asText());
            String normalizedPackage = normalizePackage(rootClassName);

            generateFromSchema(root, BASE_PACKAGE_MODEL + "." + normalizedPackage, BASE_PACKAGE_DTO + "." + normalizedPackage, BASE_PACKAGE_ENUM, rootClassName);
        } catch (Exception e) {
            log.error("Erro ao processar arquivo {}: {}", path.getFileName(), e.getMessage(), e);
        }
    }

    private void generateFromSchema(JsonNode schema, String packageModel, String packageDto, String packageEnum, String rootClassName) {
        generateEntityClass(rootClassName, schema.get("properties"), packageModel, true);
        generateDtoClass(rootClassName, schema.get("properties"), packageDto, true);
        generateRepository(rootClassName);

        JsonNode definitions = schema.get("definitions");
        if (definitions != null && definitions.isObject()) {
            definitions.fields().forEachRemaining(entry -> {
                JsonNode node = entry.getValue();
                if ("string".equals(getType(node)) && node.has("enum")) {
                    generateEnum(node, node.get("javaType").asText(), packageEnum);
                } else {
                    generateEntityClass(node.get("javaType").asText(), node.get("properties"), packageModel, false);
                    generateDtoClass(node.get("javaType").asText(), node.get("properties"), packageDto, false);
                }
            });
        }
    }

    private void generateEntityClass(String className, JsonNode properties, String packageName, boolean isRoot) {
        if (className == null || properties == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(packageName).append(";\n\n")
                .append("import jakarta.persistence.*;\n")
                .append("import jakarta.validation.constraints.*;\n")
                .append("import io.swagger.v3.oas.annotations.media.Schema;\n")
                .append("import lombok.Data;\n")
                .append("import lombok.NoArgsConstructor;\n")
                .append("import java.util.*;\n")
                .append("import com.example.demo.model.ocpp.schema.enums.*;\n\n") // Importação centralizada de enums

                .append("@Data\n@NoArgsConstructor\n");

        if (isRoot) {
            sb.append("@Entity\n")
              .append("@Table(name = \"").append(toSnakeCase(className)).append("\")\n");
        }

        sb.append("public class ").append(className).append(" {\n\n");

        if (isRoot) {
            sb.append("    @Id\n")
              .append("    @GeneratedValue(strategy = GenerationType.IDENTITY)\n")
              .append("    private Long schemaId;\n\n");
        }

        generateFields(sb, properties, true);

        sb.append("}\n");
        writeToFile(sb.toString(), packageName, className);
    }

    private void generateFields(StringBuilder sb, JsonNode props, boolean isEntity) {
        if (props != null && props.isObject()) {
            props.fields().forEachRemaining(entry -> {
                String fieldName = entry.getKey();
                JsonNode node = entry.getValue();
                String fieldType = resolveType(node);
                String description = node.has("description") ? sanitizeDescription(node.get("description").asText()) : null;

                JsonNode fieldNode = props.get(fieldName);
                sb.append("\n");
                
                // Adiciona @Size para String
                if ("String".equals(fieldType)) {
                		if(fieldNode.has("maxLength") || fieldNode.has("minLength")) {
		                    int maxLength = fieldNode.get("maxLength").asInt();
		                    sb.append("    @Size(max = ").append(maxLength);
		                    
		                    if (fieldNode.has("minLength")) {
		                        int minLength = fieldNode.get("minLength").asInt();
		                        sb.append(", min = ").append(minLength).append(")\n");
		                    }else {
	                        	sb.append(")\n");
		                    }
                		}
                }
                // Adiciona @Min/@Max para Integer, Double, Long
                if ("Integer".equals(fieldType) || "Double".equals(fieldType) || "Long".equals(fieldType)) {
                    if (fieldNode.has("minimum")) {
                        double minValue = fieldNode.get("minimum").asDouble();
                        sb.append("    @Min(").append((long) minValue).append(")\n");
                    } else if (fieldNode.has("exclusiveMinimum")) {
                        double minValue = fieldNode.get("exclusiveMinimum").asDouble() + 1;
                        sb.append("    @Min(").append((long) minValue).append(")\n");
                    }
                    if (fieldNode.has("maximum")) {
                        double maxValue = fieldNode.get("maximum").asDouble();
                        sb.append("    @Max(").append((long) maxValue).append(")\n");
                    } else if (fieldNode.has("exclusiveMaximum")) {
                        double maxValue = fieldNode.get("exclusiveMaximum").asDouble() - 1;
                        sb.append("    @Max(").append((long) maxValue).append(")\n");
                    }
                }

                // Trata array com @ElementCollection
                if (fieldNode.has("type") && "array".equals(fieldNode.get("type").asText())) {
                    sb.append("    @ElementCollection\n");
                    if (fieldNode.has("minItems")) {
                        int minItems = fieldNode.get("minItems").asInt();
                        sb.append("    @Size(min = ").append(minItems).append(")\n");
                    }
                    if (fieldNode.has("maxItems")) {
                        int maxItems = fieldNode.get("maxItems").asInt();
                        sb.append("    @Size(max = ").append(maxItems).append(")\n");
                    }
                }

                // Adiciona descrição como comentário se existir
                if (fieldNode.has("description")) {
                    String description1 = sanitizeDescription(fieldNode.get("description").asText());
                    sb.append("    /** ").append(description1).append(" */\n");
                }                
                
                
                
                if (description != null) {
                    //if (isEntity) {
                    //    sb.append("    @Schema(description = \"").append(description).append("\")\n");
                    //}
                }

                if (isEntity) {
                    sb.append("    @Column(name = \"").append(toSnakeCase(fieldName)).append("\")\n");
                } else {
                    sb.append("    @JsonProperty(\"").append(fieldName).append("\")\n");
                }

                sb.append("    private ").append(fieldType).append(" ").append(fieldName).append(";\n\n");

                if (node.has("additionalProperties")) {
                    if (isEntity) {
                        sb.append("    @Column(name = \"").append(toSnakeCase(fieldName)).append("_additional\")\n");
                    } else {
                        sb.append("    @JsonProperty(\"").append(fieldName).append("_additional\")\n");
                    }
                    sb.append("    private Boolean additionalProperties;\n\n");
                }

                if (node.has("required") && node.get("required").asBoolean()) {
                    sb.append("    @NotNull\n");
                }

                if (node.has("type") && "array".equals(node.get("type").asText())) {
                    JsonNode items = node.get("items");
                    String arrayType = resolveType(items);
                    if (isEntity) {
                        sb.append("    @ElementCollection\n");
                    } else {
                        sb.append("    @JsonProperty(\"").append(fieldName).append("\")\n");
                    }
                    sb.append("    private List<").append(arrayType).append("> ").append(fieldName).append(" = new ArrayList<>();\n\n");
                }

                // Handling Min/Max and other validations
                if (node.has("minimum")) {
                    sb.append("    @Min(").append(node.get("minimum").asDouble()).append(")\n");
                }
                if (node.has("maximum")) {
                    sb.append("    @Max(").append(node.get("maximum").asDouble()).append(")\n");
                }
            });
        }
    }
    
    private String sanitizeDescription(String desc) {
        return desc.replaceAll("\\r|\\n", " ").replaceAll("\\s+", " ").replace("\"", "\\\"").trim();
    }

    private void generateDtoClass(String className, JsonNode properties, String packageName, boolean isRoot) {
        if (className == null || properties == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(packageName).append(";\n\n")
                .append("import com.fasterxml.jackson.annotation.JsonProperty;\n")
                .append("import lombok.Data;\n")
                .append("import lombok.NoArgsConstructor;\n")
                .append("import java.util.*;\n")
                .append("import com.example.demo.model.ocpp.schema.enums.*;\n\n") // Importação centralizada de enums
                .append("@Data\n@NoArgsConstructor\n")
                .append("public class ").append(className).append(" {\n\n");

        generateFields(sb, properties, false);

        sb.append("}\n");
        writeToFile(sb.toString(), packageName, className);
    }

    private void generateRepository(String className) {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(BASE_PACKAGE_REPOSITORY).append(";\n\n")
                .append("import org.springframework.data.jpa.repository.JpaRepository;\n")
                .append("import org.springframework.stereotype.Repository;\n\n")
                .append("@Repository\n")
                .append("public interface ").append(className).append("Repository extends JpaRepository<")
                .append(className).append(", Long> {\n")
                .append("}\n");
        writeToFile(sb.toString(), BASE_PACKAGE_REPOSITORY, className + "Repository");
    }

    private void generateEnum(JsonNode node, String enumName, String packageName) {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(packageName).append(";\n\n")
                .append("public enum ").append(enumName).append(" {\n");

        node.get("enum").forEach(e -> sb.append("    ").append(e.asText().toUpperCase().replace(".", "_").replace("-", "_")).append(",\n"));

        sb.append("}\n");
        writeToFile(sb.toString(), packageName, enumName);
    }

    private String resolveType(JsonNode node) {
        if (node.has("$ref")) {
            String ref = node.get("$ref").asText();
            return ref.substring(ref.lastIndexOf("/") + 1).replace("Type", "");
        }
        if (node.has("type")) {
            String type = node.get("type").asText();
            return switch (type) {
                case "string" -> "String";
                case "integer" -> "Integer";
                case "boolean" -> "Boolean";
                case "number" -> "Double";
                case "array" -> {
                    JsonNode items = node.get("items");
                    yield "List<" + resolveType(items) + ">";
                }
                default -> "String";
            };
        }
        return "String";
    }

    private void writeToFile(String content, String basePackage, String className) {
        try {
            Path dir = Paths.get(BASE_OUTPUT_DIR, basePackage.replace('.', '/')).normalize();
            Files.createDirectories(dir);
            File file = dir.resolve(className + ".java").toFile();
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(content);
            }
        } catch (IOException e) {
            log.error("Erro ao salvar {}: {}", className, e.getMessage(), e);
        }
    }

    private String extractRootClassName(String id) {
        String[] parts = id.split(":");
        return parts[parts.length - 1];
    }

    private String normalizePackage(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    private String toSnakeCase(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    private String getType(JsonNode node) {
        return node.has("type") ? node.get("type").asText() : null;
    }
}
 	