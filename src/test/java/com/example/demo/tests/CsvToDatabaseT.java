package com.example.demo.tests;

import com.opencsv.CSVReader;
import com.example.demo.model.refdata.*;
import com.example.demo.repository.refdata.*;  // Importar os repositórios dos POJOs
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.nio.file.*;
import java.util.List;

@Slf4j
@SpringBootTest
public class CsvToDatabaseT {

    private static final Path INPUT_DIR = Paths.get("src/main/resources/schemas/csv");

    
    @Autowired
    private AdditionalInfoTypesAdhocRepository repo1;
    @Autowired
    private AdditionalInfoTypesRepository repo2;
    @Autowired
    private CharginglimitsourceenumtypeRepository repo3;
    @Autowired
    private ComponentsRepository repo4;
    @Autowired
    private ConnectorenumtypeRepository repo5;
    @Autowired
    private DmComponentsVarsRepository repo6;
    @Autowired
    private IdtokenenumtypeRepository repo7;
    @Autowired
    private PaymentbrandRepository repo8;
    @Autowired
    private PaymentrecognitionRepository repo9;
    @Autowired
    private ReasonCodesRepository repo10;
    @Autowired
    private SecurityEventsRepository repo12;
    @Autowired
    private SigningmethodRepository repo13;
    @Autowired
    private UnitsOfMeasureRepository repo14;
    @Autowired
    private VariablesRepository repo15;
    
    @Transactional
    public void saveReferenceData() throws Exception {
        Files.walk(INPUT_DIR)
            .filter(Files::isRegularFile)
            .filter(path -> path.toString().endsWith(".csv"))
            .forEach(path -> {
                try (CSVReader reader = new CSVReader(new FileReader(path.toFile()))) {
                    List<String[]> rows = reader.readAll();
                    if (rows.isEmpty()) return;

                    String[] headers = rows.get(0);
                    String aux2 = headers[0];
                    String[] hhh = aux2.split(";");
                    for(String a: hhh) {
                    	log.debug(a.toString());	
                    }                    
                    String className = toCamelCase(path.getFileName().toString().replace(".csv", ""));
                    Class<?> pojoClass = Class.forName("com.example.demo.model.refdata." + className);
                    int i =1;
                    while ( i < rows.size()) {
                        String[] row = rows.get(i);                        
                        String aux = row[0];                        
                        String[] aux1 = aux.split(";");
                        for (String a: aux1) {
                        	log.debug(a.toString());	
                        }                        
                        Object pojo = pojoClass.getDeclaredConstructor().newInstance();
                        for (int j = 0; j < aux1.length; j++) {                            
                            log.debug("nome da classe :"+pojo.getClass().getName());
                            String fieldName = toCamelCase(hhh[j]);
                            log.debug(fieldName);
                            Field field = pojoClass.getDeclaredField(fieldName);
                            field.setAccessible(true);
                            log.debug(aux1[j]);
                            field.set(pojo, aux1[j]);  // Aqui pode ser necessário um tipo conversão, dependendo do tipo do campo
                        }                                               
                        savePojo(pojo, className);
                        log.debug("inseriu linha "+i);
                        i++;
                    }
                } catch (Exception e) {
                    log.error("Erro ao processar {}: {}", path.getFileName(), e.getMessage());
                }
            });
    }
    
     private void savePojo(Object pojo, String className) {
        switch (className) {
            case "AdditionalInfoTypesAdhoc":
            	AdditionalInfoTypesAdhoc obj = (AdditionalInfoTypesAdhoc) pojo;
            	repo1.save(obj); // Salva o POJO correspondente à tabela no banco
                break;
            case "AdditionalInfoTypes":
            	AdditionalInfoTypes obj1 = (AdditionalInfoTypes) pojo;
            	repo2.save(obj1); // Salva o POJO correspondente à tabela no banco
                break;
            case "Charginglimitsourceenumtype":
            	Charginglimitsourceenumtype obj2 = (Charginglimitsourceenumtype) pojo;
            	repo3.save(obj2); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "Components":
            	Components obj3 = (Components) pojo;
            	repo4.save(obj3); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "Connectorenumtype":
            	Connectorenumtype obj4 = (Connectorenumtype) pojo;
            	repo5.save(obj4); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "DmComponentsVars":
            	DmComponentsVars obj5 = (DmComponentsVars) pojo;
            	repo6.save(obj5); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "Idtokenenumtype":
            	Idtokenenumtype obj6 = (Idtokenenumtype) pojo;
            	repo7.save(obj6); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "Paymentbrand":
            	Paymentbrand obj7 = (Paymentbrand) pojo;
            	repo8.save(obj7); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "Paymentrecognition":
            	Paymentrecognition obj8 = (Paymentrecognition) pojo;
            	repo9.save(obj8); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "ReasonCodes":
            	ReasonCodes obj9 = (ReasonCodes) pojo;
            	repo10.save(obj9); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "SecurityEvents":
            	SecurityEvents obj11 = (SecurityEvents) pojo;
            	repo12.save(obj11); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "UnitsOfMeasure":
            	UnitsOfMeasure obj12 = (UnitsOfMeasure) pojo;
            	repo14.save(obj12); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "SigningmethodRepository":
            	Signingmethod obj13 = (Signingmethod) pojo;
            	repo13.save(obj13); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            case "Variables":
            	Variables obj14 = (Variables) pojo;
            	repo15.save(obj14); // Salva o POJO correspondente à tabela no banco
                break;            // Outros casos conforme necessário
            default:
                log.warn("Classe não mapeada: " + className);
                break;
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
}