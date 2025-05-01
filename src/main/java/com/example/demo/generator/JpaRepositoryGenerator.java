package com.example.demo.generator;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class JpaRepositoryGenerator {

    private final Configuration freemarker;

    public JpaRepositoryGenerator(Configuration freemarker) {
        this.freemarker = freemarker;
    }

    public void generateRepository(String packageName, String className, String outputDir) throws Exception {
        String repositoryClassName= className + "Repository";
        //String repoPackage = packageName.replace(".schema", ".repository");

        Map<String, Object> data = new HashMap<>();
        data.put("packageName", packageName);
        data.put("className", className);
        data.put("repositoryName", repositoryClassName);

        File outputFile = new File("src/main/java/" + packageName.replace('.', '/') + "/" + repositoryClassName + ".java");
        outputFile.getParentFile().mkdirs();

        Template template = freemarker.getTemplate("repository.ftl");
        try (Writer writer = new FileWriter(outputFile)) {
            template.process(data, writer);
        }
    }
}
