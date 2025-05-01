package com.example.demo.generator;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JpaFieldBuilder {

    public static PojoField fromSchema(String fieldName, JsonNode node, Set<String> requiredList, Map<String, String> typeMap) {
        String javaName = toLowerCamelCase(fieldName);
        String javaType = resolveType(node, fieldName, typeMap);
        boolean isEnum = node.has("enum");
        boolean isArray = "array".equals(node.path("type").asText());
        boolean isRef = node.has("$ref");
        boolean isRequired = requiredList.contains(fieldName);

        boolean isRelation = isRef || (isArray && node.path("items").has("$ref"));
        String relationType = null;

        if (isRelation) {
            relationType = isArray ? "OneToMany" : "OneToOne";
        }

        String jpaAnnotation = JpaAnnotationBuilder.buildFor(fieldName, javaType, isEnum, isRelation, relationType, isRequired);

        return PojoField.builder()
                .originalName(fieldName)
                .name(javaName)
                .type(javaType)
                .isRelation(isRelation)
                .relationType(relationType)
                .isEnum(isEnum)
                .isRequired(isRequired)
                .jpaAnnotation(jpaAnnotation)
                .build();
    }

    private static String resolveType(JsonNode node, String fieldName, Map<String, String> typeMap) {
        if (node.has("$ref")) {
            String ref = node.get("$ref").asText();
            String defKey = ref.substring(ref.lastIndexOf("/") + 1);
            return typeMap.getOrDefault(defKey, toUpperCamelCase(defKey.replace("Type", "")));
        }

        if (node.has("enum")) {
            return toUpperCamelCase(fieldName);
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
