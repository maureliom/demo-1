package com.example.demo.logs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogEntry {
    private String timestamp;
    private String deviceId;
    private String level;
    private String message;
}
