package com.example.demo.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PojoGenerator {
    private final Configuration freemarker;

    public PojoGenerator(Configuration freemarker) {
        this.freemarker = freemarker;
    }

    public void generatePojo(String packageName, String className, String description, List<PojoField> fields, File outputFile, com.fasterxml.jackson.databind.JsonNode schemaNode) throws Exception {
        Template template = freemarker.getTemplate("pojo.ftl");

        boolean usesList = fields.stream().anyMatch(f -> f.getType().contains("List<"));

        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("className", className);
        data.put("fields", fields);
        data.put("description", description);
        data.put("usesList", usesList);

        outputFile.getParentFile().mkdirs();
        try (Writer writer = new FileWriter(outputFile)) {
            template.process(data, writer);
        }
    }

    public void generatePojo(String packageName, String className, String description, List<PojoField> fields, File outputFile) throws Exception {
        generatePojo(packageName, className, description, fields, outputFile, null);
    }
}
