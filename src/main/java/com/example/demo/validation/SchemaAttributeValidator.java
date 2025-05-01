package com.example.demo.validation;

import java.util.Set;

public class SchemaAttributeValidator {
    private static final Set<String> ALLOWED_ATTRIBUTES = Set.of(
        "$schema", "$id", "type", "properties", "required", "$ref", "enum",
        "maxLength", "minLength", "maximum", "minimum", "exclusiveMinimum",
        "exclusiveMaximum", "pattern", "additionalProperties", "items",
        "description", "definitions", "javaType", "comment"
    );

    public static void validateSchemaNode(String path, String attribute) {
        if (!ALLOWED_ATTRIBUTES.contains(attribute)) {
            throw new IllegalArgumentException("❌ Unrecognized schema attribute '" + attribute + "' at: " + path);
        }
    }
}
