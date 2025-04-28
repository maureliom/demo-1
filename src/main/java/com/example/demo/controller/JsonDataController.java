package com.example.demo.controller;

import com.example.demo.service.JsonDataService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/json")
@RequiredArgsConstructor
public class JsonDataController {

    private final JsonDataService service;

    @Operation(summary = "Upload de arquivo JSON")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadJson(@RequestParam("file") MultipartFile file) {
        service.saveJsonFile(file);
        return ResponseEntity.ok("JSON processado com sucesso.");
    }

    @Operation(summary = "Download do JSON original")
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadJson(@PathVariable Long id) {
        byte[] jsonFile = service.downloadJson(id);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"restored.json\"")
                .body(jsonFile);
    }
}
