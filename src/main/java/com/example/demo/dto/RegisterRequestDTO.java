package com.example.demo.dto;

import lombok.Data;
import com.example.demo.model.RoleName;

@Data
public class RegisterRequestDTO {
    private String username;
    private String email;
    private String password;
    private RoleName role;
}
