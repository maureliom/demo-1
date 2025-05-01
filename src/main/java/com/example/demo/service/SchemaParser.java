package com.example.demo.service;

import com.example.demo.validation.SchemaAttributeValidator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class SchemaParser {

    private final ObjectMapper mapper = new ObjectMapper();

    public void validateSchema(File schemaFile) throws Exception {
        JsonNode rootNode = mapper.readTree(schemaFile);
        validateRecursive(rootNode, schemaFile.getName());
    }

    private void validateRecursive(JsonNode node, String path) {
        if (node.isObject()) {
            //if (!node.has("type") && !node.has("$ref") && !node.has("enum") && !node.has("properties") && !node.has("definitions")) {
            //    throw new IllegalArgumentException("❌ Unsupported object structure at: " + path);
            //}
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String attribute = entry.getKey();
                JsonNode child = entry.getValue();

                if (attribute.equals("oneOf") || attribute.equals("anyOf") || attribute.equals("allOf")) {
                    throw new IllegalArgumentException("❌ Unsupported combinator keyword (" + attribute + ") at: " + path);
                }

                //SchemaAttributeValidator.validateSchemaNode(path, attribute);

                if (child.isObject() || child.isArray()) {
                    validateRecursive(child, path + " > " + attribute);
                }
            }
        } else if (node.isArray()) {
            for (JsonNode item : node) {
                validateRecursive(item, path + "[]");
            }
        }
    }
}
