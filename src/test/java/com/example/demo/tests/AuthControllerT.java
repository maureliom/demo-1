package com.example.demo.tests;

import com.example.demo.controller.AuthController;
import com.example.demo.dto.AuthRequestDTO;
import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.model.task.RoleName;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.task.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private ObjectMapper objectMapper = new ObjectMapper();

    // Teste de Login e Obtenção do Token
    @Test
    void testAuthenticateUser_ReturnsToken() throws Exception {
        AuthRequestDTO request = new AuthRequestDTO();
        request.setUsername("john");
        request.setPassword("123456");

        // Chama o endpoint de login e pega o token JWT gerado
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(result -> {
                // Verifica se o token está presente na resposta
                String token = result.getResponse().getContentAsString();
                assertNotNull(token, "Token não pode ser nulo");
                assertFalse(token.isEmpty(), "Token não pode ser vazio");
                
                // Armazena o token para utilizar nas próximas requisições
                //this.token = token;
            });
    }

    // Teste de Acesso a Endpoint Protegido com o Token Obtido
    @Test
    void testAccessProtectedEndpoint_WithValidToken() throws Exception {
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
        mockMvc.perform(get("/api/auth/default")  // Endpoint protegido
                .header("Authorization", "Bearer " + token)  // Passa o token no header
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();
    }

    // Teste de Acesso com Token Inválido
    @Test
    void testAccessProtectedEndpoint_WithInvalidToken() throws Exception {
        // Requisição com um token inválido
        mockMvc.perform(get("/api/auth/default")
                .header("Authorization", "Bearer invalid-token")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isForbidden()); // Espera que o acesso seja negado
    }
}
