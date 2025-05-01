package com.example.demo.generator;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FieldBuilder {

    public static PojoField fromSchema(String fieldName, JsonNode node, Set<String> requiredList, Map<String, String> typeMap) {
        String javaName = toLowerCamelCase(fieldName);
        String javaType = resolveType(node, fieldName, typeMap);
        String description = node.path("description").asText(null);
        String validation = buildValidation(node);
        boolean isEnum = node.has("enum");
        boolean isArray = "array".equals(node.path("type").asText());
        boolean isRef = node.has("$ref");
        boolean isRequired = requiredList.contains(fieldName);

        boolean isRelation = isRef || (isArray && node.path("items").has("$ref"));
        String relationType = null;

        if (isRelation) {
            relationType = isArray ? "OneToMany" : "OneToOne";
        }

        return PojoField.builder()
                .originalName(fieldName)
                .name(javaName)
                .type(javaType)
                .description(description)
                .validation(validation)
                .isRelation(isRelation)
                .relationType(relationType)
                .isEnum(isEnum)
                .isRequired(isRequired)
                .build();
    }

    private static String buildValidation(JsonNode node) {
        List<String> annotations = new ArrayList<>();

        if (node.has("maxLength") || node.has("minLength")) {
            int max = node.path("maxLength").asInt(-1);
            int min = node.path("minLength").asInt(-1);
            annotations.add(String.format("@Size(%s%s)",
                    min >= 0 ? "min = " + min : "",
                    max >= 0 ? (min >= 0 ? ", " : "") + "max = " + max : ""));
        }

        if (node.has("minimum")) {
            annotations.add(String.format("@Min(%d)", node.get("minimum").asInt()));
        }

        if (node.has("maximum")) {
            annotations.add(String.format("@Max(%d)", node.get("maximum").asInt()));
        }

        if (node.has("pattern")) {
            String pattern = node.get("pattern").asText().replace("\\", "\\\\").replace("\"", "\\\"");
            annotations.add(String.format("@Pattern(regexp = \"%s\")", pattern));
        }

        if (node.has("exclusiveMinimum") || node.has("exclusiveMaximum")) {
            annotations.add("// TODO: exclusiveMinimum/exclusiveMaximum not supported by Jakarta validation");
        }

        if (node.has("additionalProperties")) {
            JsonNode apNode = node.get("additionalProperties");
            if (apNode.isBoolean() && !apNode.asBoolean()) {
                // OK
            } else {
                throw new IllegalArgumentException("Unsupported: additionalProperties must be boolean. Path: ...");
            }
        }

        return String.join("\n    ", annotations);
    }

    private static String resolveType(JsonNode node, String fieldName, Map<String, String> typeMap) {
        if (node.has("$ref")) {
            String ref = node.get("$ref").asText();
            String defKey = ref.substring(ref.lastIndexOf("/") + 1);
            if (typeMap.containsKey(defKey)) {
                return typeMap.get(defKey);
            }
            return toUpperCamelCase(defKey.replace("Type", ""));
        }

        if (node.has("enum")) {
            return toUpperCamelCase(fieldName) + "Enum";
        }

        if (node.has("type")) {
            String type = node.get("type").asText();
            switch (type) {
                case "string": return "String";
                case "integer": return "Integer";
                case "number": return "Double";
                case "boolean": return "Boolean";
                case "array": {
                    JsonNode items = node.get("items");
                    return "List<" + resolveType(items, fieldName, typeMap) + ">";
                }
                case "object": return "Object";
            }
        }

        return "Object";
    }

    private static String toUpperCamelCase(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    private static String toLowerCamelCase(String s) {
        if (s.length() == 1) return s.toLowerCase();
        return Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }
}
