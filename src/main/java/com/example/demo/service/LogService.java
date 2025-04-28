package com.example.demo.service;

import com.example.demo.dto.LogEntry;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

@Service
public class LogService {

    public List<LogEntry> readCsv(MultipartFile file) throws Exception {
        return new CsvToBeanBuilder<LogEntry>(new InputStreamReader(file.getInputStream()))
                .withType(LogEntry.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
    }

    public List<LogEntry> readJson(MultipartFile file) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file.getInputStream(), new TypeReference<>() {});
    }
}
