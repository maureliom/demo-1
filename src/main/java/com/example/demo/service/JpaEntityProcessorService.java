package com.example.demo.service;

import com.example.demo.config.PojoGeneratorProperties;
import com.example.demo.generator.JpaEntityGenerator;
import com.example.demo.generator.JpaRepositoryGenerator;
import com.example.demo.generator.SchemaAnalyzer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaEntityProcessorService {

    private final PojoGeneratorProperties properties;
    private final Configuration freemarker;

    public void run() {
        File schemaDir = new File(properties.getSchemaDirectory());
//        List<Map<String, List<Integer>>> occurrences = new SchemaAnalyzer().analyzeDefinitionOccurrences(schemaDir.toPath());
        Map<String, Integer> schemaMap = new SchemaAnalyzer().findMultiUsedDefinitions(schemaDir.toPath());
        schemaMap.forEach((k, v) -> System.out.println(k + " -> " + v + " occurrences")); 
        
    	if (!schemaDir.exists() || !schemaDir.isDirectory()) {
        throw new IllegalArgumentException("Invalid schema directory: " + schemaDir.getAbsolutePath());
        
        }

        File[] schemaFiles = schemaDir.listFiles((dir, name) -> name.endsWith(".json"));
        

        if (schemaFiles == null || schemaFiles.length == 0) {
            throw new IllegalStateException("No schema files found in directory: " + schemaDir.getAbsolutePath());
        }

        log.info("Generating JPA entities and repositories for {} schema files...", schemaFiles.length);

        for (File schemaFile : schemaFiles) {
            try {
                generateJpaEntityAndRepository(schemaFile, schemaMap);
            } catch (Exception e) {
                log.error("❌ Error generating JPA entity for: {}", schemaFile.getName(), e);
            }
        }
    }

    private void generateJpaEntityAndRepository(File schemaFile, Map<String, Integer> occurrences) throws Exception {
        String className = deriveClassName(schemaFile);
        String subPackage = deriveSubPackage(schemaFile);

        String entityPackage = "com.example.demo.model.ocpp.schema.jpa." + subPackage;
        String entityOutputDir = "src/main/java/" + entityPackage.replace('.', '/');

        String repositoryPackage = "com.example.demo.repository.ocpp.schema.jpa." + subPackage;
        String repositoryOutputDir = "src/main/java/" + repositoryPackage.replace('.', '/');

        ObjectMapper mapper = new ObjectMapper();
        JsonNode schema = mapper.readTree(schemaFile);

        new JpaEntityGenerator(freemarker, occurrences).generateEntity(schema, entityPackage, className, entityOutputDir);
        new JpaRepositoryGenerator(freemarker).generateRepository(repositoryPackage, className, repositoryOutputDir);
    }

    private String deriveClassName(File schemaFile) {
        String name = schemaFile.getName();
        return toUpperCamelCase(name.replace(".json", ""));
    }

    private String deriveSubPackage(File schemaFile) {
        return schemaFile.getName()
            .replace(".json", "")
            .replaceAll("([a-z])([A-Z])", "$1_$2")
            .toLowerCase();
    }

    private String toUpperCamelCase(String input) {
        return Arrays.stream(input.split("[^a-zA-Z0-9]"))
            .filter(s -> !s.isEmpty())
            .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
            .reduce("", String::concat);
    }
}
