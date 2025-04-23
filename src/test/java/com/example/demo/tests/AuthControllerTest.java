package com.example.demo.tests;

import com.example.demo.controller.AdminController;
import com.example.demo.controller.AuthController;
import com.example.demo.dto.AuthRequestDTO;
import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.model.RoleName;
import com.example.demo.security.JwtAuthenticationFilter;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.SecurityConfig;
import com.example.demo.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testAuthenticateUser_ReturnsToken() throws Exception {
        AuthRequestDTO request = new AuthRequestDTO();
        request.setUsername("john");
        request.setPassword("123456");

        when(authService.authenticateStr(request)).thenReturn("fake-jwt-token");

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON) // <- Adiciona isso aqui
                .accept(MediaType.TEXT_PLAIN)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(content().string("fake-jwt-token"));
    }

    @Test
    void testRegisterUser_ReturnsSuccessMessage() throws Exception {
        RegisterRequestDTO registerRequest = new RegisterRequestDTO();
        registerRequest.setUsername("john");
        registerRequest.setEmail("john@example.com");
        registerRequest.setPassword("123456");
        registerRequest.setRole(RoleName.USER);

        when(authService.registerUser(registerRequest)).thenReturn("User registered successfully");

        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON) // <- Adiciona isso aqui
                .accept(MediaType.TEXT_PLAIN)
                .content(objectMapper.writeValueAsString(registerRequest)))
            .andExpect(status().isOk())
            .andExpect(content().string("User registered successfully"));
    }
}
