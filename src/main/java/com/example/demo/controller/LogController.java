package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.LogEntry;
import com.example.demo.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/csv")
    public ResponseEntity<List<LogEntry>> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            List<LogEntry> logs = logService.readCsv(file);
            return ResponseEntity.ok(logs);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/json")
    public ResponseEntity<List<LogEntry>> uploadJson(@RequestParam("file") MultipartFile file) {
        try {
            List<LogEntry> logs = logService.readJson(file);
            return ResponseEntity.ok(logs);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
