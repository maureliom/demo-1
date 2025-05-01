package com.example.demo.generator;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class EnumFieldGenerator {

    public static EnumSpec generateEnum(String enumName, JsonNode node) {
        JsonNode enumArray = node.get("enum");
        List<EnumConstant> constants = new ArrayList<>();
        for (JsonNode valueNode : enumArray) {
            String original = valueNode.asText();
            String sanitized = sanitize(original);
            constants.add(new EnumConstant(sanitized, original));
        }
        return new EnumSpec(enumName, constants, node.path("description").asText(null));
    }

    private static String sanitize(String raw) {
        String result = raw.toUpperCase().replace("-", "_").replace(".", "_");
        if (Character.isDigit(result.charAt(0))) result = "_" + result;
        return result;
    }

    public record EnumConstant(String name, String originalValue) {}
    public record EnumSpec(String name, List<EnumConstant> values, String description) {}
}
