package com.example.demo.generator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class SchemaAnalyzer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    
    public Map<String, Integer> findMultiUsedDefinitions(Path schemaDir) {
        Map<String, Integer> definitionCounts = new HashMap<>();

        try (var files = Files.list(schemaDir)) {
            for (Path schemaFile : files.toList()) {
                if (!Files.isRegularFile(schemaFile)) continue;

                JsonNode schema = objectMapper.readTree(schemaFile.toFile());

                JsonNode definitions = schema.get("definitions");
                if (definitions == null || !definitions.isObject()) continue;

                Iterator<String> fieldNames = definitions.fieldNames();
                while (fieldNames.hasNext()) {
                    String defName = fieldNames.next();
                    definitionCounts.merge(defName, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Error reading schema files", e);
        }

        return definitionCounts;
    }
    //String targetDefinition = "MyDefinition";
    //Integer occurrences = definitionCounts.getOrDefault(targetDefinition, 0);
    //System.out.println("Occurrences of '" + targetDefinition + "': " + occurrences);
    
    //Path schemaDir = Paths.get("path/to/your/schemas");
    //SchemaAnalyzer analyzer = new SchemaAnalyzer();
    //Map<String, Integer> counts = analyzer.countDefinitionOccurrences(schemaDir);
    //counts.forEach((k, v) -> System.out.println(k + " -> " + v + " occurrences"));    

    
    public List<Map<String, List<Integer>>> analyzeDefinitionOccurrences(Path schemaDir) {
        Map<String, Map<String, Integer>> defToFileCountMap = new HashMap<>();

        try (var files = Files.list(schemaDir)) {
            for (Path schemaFile : files.toList()) {
                if (!Files.isRegularFile(schemaFile)) continue;

                JsonNode schema = objectMapper.readTree(schemaFile.toFile());
                String rootClassName = fileNameToClassName(schemaFile.getFileName().toString());

                JsonNode definitions = schema.get("definitions");
                if (definitions == null || !definitions.isObject()) continue;

                Iterator<String> fieldNames = definitions.fieldNames();
                while (fieldNames.hasNext()) {
                    String defName = fieldNames.next();

                    // Increment usage count per file
                    defToFileCountMap
                        .computeIfAbsent(defName, k -> new HashMap<>())
                        .merge(rootClassName, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Error reading schema files", e);
        }

        // Convert to List<Map<String, List<Integer>>>
        return defToFileCountMap.entrySet().stream()
            .map(entry -> {
                String defName = entry.getKey();
                List<Integer> occurrenceCounts = new ArrayList<>(entry.getValue().values());
                return Map.of(defName, occurrenceCounts);
            })
            .collect(Collectors.toList());
    }


    private String fileNameToClassName(String fileName) {
        // Remove extension (e.g., .json)
        String baseName = fileName.replaceAll("\\.json$", "");

        // Remove non-alphanumeric characters and convert to CamelCase
        String[] parts = baseName.split("[^a-zA-Z0-9]");
        StringBuilder className = new StringBuilder();

        for (String part : parts) {
            if (!part.isEmpty()) {
                className.append(Character.toUpperCase(part.charAt(0)));
                if (part.length() > 1) {
                    className.append(part.substring(1));
                }
            }
        }

        return className.toString();
    }
    
    public void checkAndCountKeyOccurrences(List<Map<String, List<Integer>>> defOccurrences, String targetKey) {
        for (Map<String, List<Integer>> map : defOccurrences) {
            if (map.containsKey(targetKey)) {
                List<Integer> occurrences = map.get(targetKey);
                int total = occurrences.stream().mapToInt(Integer::intValue).sum();
                System.out.printf("Definition '%s' found with %d total occurrence(s): %s%n", targetKey, total, occurrences);
                return;
            }
        }
        System.out.printf("Definition '%s' not found in the list.%n", targetKey);
    }    
    //SchemaAnalyzer analyzer = new SchemaAnalyzer();
    //List<Map<String, List<Integer>>> result = analyzer.analyzeDefinitionOccurrences(Paths.get("your/schema/dir"));

    //analyzer.checkAndCountKeyOccurrences(result, "Address");
    public void displayAllDefinitionOccurrences(List<Map<String, List<Integer>>> defOccurrences) {
        Map<String, Integer> totalOccurrences = new HashMap<>();

        for (Map<String, List<Integer>> map : defOccurrences) {
            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                String key = entry.getKey();
                int sum = entry.getValue().stream().mapToInt(Integer::intValue).sum();
                totalOccurrences.merge(key, sum, Integer::sum);
            }
        }

        // Print results
        totalOccurrences.forEach((key, count) ->
            System.out.printf("Definition '%s' occurs %d time(s)%n", key, count)
        );
    }
    //SchemaAnalyzer analyzer = new SchemaAnalyzer();
    //List<Map<String, List<Integer>>> result = analyzer.analyzeDefinitionOccurrences(Paths.get("your/schema/dir"));

    //analyzer.displayAllDefinitionOccurrences(result);    
    
}
