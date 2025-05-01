package com.example.demo.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class EnumGenerator {
    private final Configuration freemarker;

    public EnumGenerator(Configuration freemarker) {
        this.freemarker = freemarker;
    }

    public void generateEnum(String packageName, EnumFieldGenerator.EnumSpec spec, File outputFile) throws Exception {
        Template template = freemarker.getTemplate("enum.ftl");

        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("enumName", spec.name());
        data.put("constants", spec.values());
        data.put("description", spec.description());

        outputFile.getParentFile().mkdirs();
        try (Writer writer = new FileWriter(outputFile)) {
            template.process(data, writer);
        }
    }
}
