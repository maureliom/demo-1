package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDTO;

import com.example.demo.dto.JwtResponseDTO;
import com.example.demo.model.task.RoleName;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.task.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody AuthRequestDTO request) {
        try {
            // Valida credenciais e retorna as roles
            List<RoleName> roles = authService.authenticate(request);
            
            // Gera o token com username e roles
            String token = jwtTokenProvider.generateTokenWithRoles(request.getUsername(), roles);

            log.info("Login bem-sucedido para o usuário: {}", request.getUsername());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            log.error("Falha ao autenticar usuário {}: {}", request.getUsername(), e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }
    }
    @GetMapping("/default")
    public ResponseEntity<String> getDefault() {
        return ResponseEntity.ok("default content");
    }    
}
