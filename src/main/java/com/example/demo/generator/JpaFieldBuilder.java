package com.example.demo.generator;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Slf4j
public class JpaFieldBuilder {

    public static PojoField fromSchema(boolean isEnum, String fieldName, JsonNode node, Set<String> requiredList, Map<String, String> typeMap, Map<String, Integer> occurrences) {
        String javaName = toLowerCamelCase(fieldName);
        String javaType = resolveType(node, fieldName, typeMap, occurrences);        
        boolean isArray = "array".equals(node.path("type").asText());
        boolean isRef = node.has("$ref");
        boolean isRequired = requiredList.contains(fieldName);

        boolean isRelation = isRef || (isArray && node.path("items").has("$ref"));
        String relationType = null;

        if (isRelation) {
            relationType = isArray ? "OneToMany" : "OneToOne";
        }

        log.info("javaName "+javaName+"\n"+
        		" javaType "+javaType+"\n"+
        		" isArray "+isArray+"\n"+
        		" isRef "+isRef+"\n"+
        		" fieldName "+fieldName+"\n"+ 
        		" javaType "+javaType+"\n"+
        		" isEnum "+isEnum+"\n"+
        		" isRelation "+isRelation+"\n"+ 
        		" relationType "+relationType+"\n"+ 
        		" isRequired "+isRequired);
        
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

    private static String resolveType(JsonNode node, String fieldName, Map<String, String> typeMap, Map<String, Integer> occurrences) {
        if (node.has("$ref")) {
            String ref = node.get("$ref").asText();
            String defKey = ref.substring(ref.lastIndexOf("/") + 1);
            String baseType = typeMap.getOrDefault(defKey, toUpperCamelCase(defKey.replace("Type", "")));
           
            if (occurrences.getOrDefault(defKey, 0) > 1 && typeMap.containsKey("__rootClass")) {
            	if (!baseType.contains(typeMap.get("__rootClass"))){
            		return baseType + typeMap.get("__rootClass");
            	}                
            }
            
            return typeMap.getOrDefault(defKey, toUpperCamelCase(defKey.replace("Type", "")));
        }

        if (node.has("enum")) {
        	//return "String";
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
                    return "List<" + resolveType(items, fieldName, typeMap, occurrences) + ">";
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
