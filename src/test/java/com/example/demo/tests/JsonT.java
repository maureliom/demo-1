package com.example.demo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.task.JsonData;
import com.example.demo.repository.task.JsonDataRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(false)
class JsonT {

    @Autowired
    private JsonDataRepository repository;

    @Test
    void shouldSaveAndReadJsonContent() throws Exception {
        // Criar JSON dinâmico
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree("{\"device\": \"Sensor A\", \"status\": \"active\"}");

        // Criar entidade
        JsonData jsondata = new JsonData();
        jsondata.setJsonContent(jsonNode);

        // Salvar
        JsonData saved = repository.save(jsondata);

        // Buscar
        Optional<JsonData> retrieved = repository.findById(saved.getId());

        assertTrue(retrieved.isPresent());
        assertEquals("Sensor A", retrieved.get().getJsonContent().get("device").asText());
        assertEquals("active", retrieved.get().getJsonContent().get("status").asText());
    }
}

