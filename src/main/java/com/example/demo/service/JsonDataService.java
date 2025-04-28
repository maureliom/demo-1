package com.example.demo.service;

import com.example.demo.model.task.JsonData;
import com.example.demo.repository.task.JsonDataRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class JsonDataService {

    private final JsonDataRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void saveJsonFile(MultipartFile file) {
        try {
            byte[] fileBytes = file.getBytes();
            String jsonText = new String(fileBytes);

            JsonNode jsonNode = objectMapper.readTree(jsonText);

            JsonData jsonData = new JsonData();
            jsonData.setFilename(file.getOriginalFilename());
            jsonData.setOriginalFile(fileBytes);
            jsonData.setJsonContent(jsonNode);

            repository.save(jsonData);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao processar o JSON: " + e.getMessage());
        }
    }

    public byte[] downloadJson(Long id) {
        JsonData data = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Arquivo não encontrado"));
        return data.getOriginalFile();
    }
}
