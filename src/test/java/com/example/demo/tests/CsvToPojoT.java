package com.example.demo.tests;

import com.opencsv.CSVReader;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.nio.file.*;
import java.util.*;

@Slf4j
public class CsvToPojoT {

    private static final Path INPUT_DIR = Paths.get("src/main/resources/schemas/csv");
    private static final String OUTPUT_DIR = "src/main/java/com/example/demo/model/refdata";
    private static final String REPO_OUTPUT_DIR = "src/main/java/com/example/demo/repository/refdata";
    private static final String BASE_PACKAGE = "com.example.demo.model.refdata";
    private static final String REPO_PACKAGE = "com.example.demo.repository.refdata";


    public void generatePojosAndRepositoriesFromCsv() throws Exception {
        Files.createDirectories(Paths.get(OUTPUT_DIR));
        Files.createDirectories(Paths.get(REPO_OUTPUT_DIR));

        Files.walk(INPUT_DIR)
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".csv"))
                .forEach(path -> {
                    try (CSVReader reader = new CSVReader(new FileReader(path.toFile()))) {
                        List<String[]> rows = reader.readAll();
                         
                        if (rows.isEmpty()) return;

                        String[] headers = rows.get(0);
                        String className = toCamelCase(path.getFileName().toString().replace(".csv", ""));

                        generatePojoFile(className, headers);
                        generateRepositoryFile(className);

                    } catch (Exception e) {
                        log.error("Erro ao processar {}: {}", path.getFileName(), e.getMessage());
                    }
                });
    }
    
    private void generatePojoFile(String className, String[] headers) throws Exception {
        StringBuilder builder = new StringBuilder();

        builder.append("package ").append(BASE_PACKAGE).append(";\n\n")
               .append("import jakarta.persistence.*;\n")
               .append("import lombok.Data;\n")
               .append("import lombok.NoArgsConstructor;\n\n")
               .append("@Entity\n")
               .append("@Table(name = \"").append(toSnakeCase(className)).append("\")\n")
               .append("@Data\n")
               .append("@NoArgsConstructor\n")
               .append("public class ").append(className).append(" {\n\n")
               .append("    @Id\n")
               .append("    @GeneratedValue(strategy = GenerationType.IDENTITY)\n")
               .append("    private Long id;\n\n");

        	String aux = headers[0];
        	String[] aux1 = aux.split(";");
        	for(String header: aux1) {
        	log.debug("nome da coluna: "+header);
            String fieldName = toCamelCase(header);
            builder.append("    @Column(name = \"")
            .append(toSnakeCase(header))
            .append("\", columnDefinition = \"TEXT\")\n")
                   .append("    private String ").append(fieldName).append(";\n\n");
        	}
        builder.append("}\n");

        Path path = Paths.get(OUTPUT_DIR, className + ".java");
        try (FileWriter writer = new FileWriter(path.toFile())) {
            writer.write(builder.toString());
        }
    }

    private void generateRepositoryFile(String className) throws Exception {
        StringBuilder builder = new StringBuilder();

        builder.append("package ").append(REPO_PACKAGE).append(";\n\n")
               .append("import com.example.demo.model.refdata.").append(className).append(";\n")
               .append("import org.springframework.data.jpa.repository.JpaRepository;\n\n")
               .append("public interface ").append(className).append("Repository extends JpaRepository<")
               .append(className).append(", Long> {\n}\n");

        Path path = Paths.get(REPO_OUTPUT_DIR, className + "Repository.java");
        try (FileWriter writer = new FileWriter(path.toFile())) {
            writer.write(builder.toString());
        }
    }

    private String toCamelCase(String input) {
        String[] parts = input.replaceAll("[^a-zA-Z0-9]", " ").split(" ");
        StringBuilder camel = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                camel.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase());
            }
        }
        return camel.toString();
    }

    private String toSnakeCase(String input) {
        return input.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }
}
