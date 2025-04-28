package com.example.demo.tests;

import com.example.demo.controller.AdminController;
import com.example.demo.dto.AuthRequestDTO;
import com.example.demo.security.JwtAuthenticationFilter;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.task.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.demo.config.SecurityConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthService authService;
    
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testAdminAccessWithAdminRole_ShouldReturnOk() throws Exception {
        // Primeiramente, realiza o login para obter o token
        AuthRequestDTO request = new AuthRequestDTO();
        request.setUsername("admin");
        request.setPassword("123456");

        // Executa a requisição de login e obtém o token
        MvcResult result = mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andReturn();

        // Extraímos o token da resposta
        String token = result.getResponse().getContentAsString();

        // Agora, fazemos um novo request ao endpoint protegido, com o token no header
        mockMvc.perform(get("/api/admin/dashboard")  // Endpoint protegido
                .header("Authorization", "Bearer " + token)  // Passa o token no header
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test

    void testAdminAccessWithUserRole_ShouldReturnForbidden() throws Exception {
        // Primeiramente, realiza o login para obter o token
        AuthRequestDTO request = new AuthRequestDTO();
        request.setUsername("john");
        request.setPassword("123456");

        // Executa a requisição de login e obtém o token
        MvcResult result = mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andReturn();

        // Extraímos o token da resposta
        String token = result.getResponse().getContentAsString();

        // Agora, fazemos um novo request ao endpoint protegido, com o token no header
        mockMvc.perform(get("/api/admin/dashboard")  // Endpoint protegido
                .header("Authorization", "Bearer " + token)  // Passa o token no header
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isForbidden())
            .andReturn();
    }
}