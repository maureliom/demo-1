package com.example.demo.tests;

import com.example.demo.dto.AuthRequestDTO;
import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.model.Role;
import com.example.demo.model.RoleName;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        roleRepository.deleteAll();

        // Cria o papel "ROLE_USER" no banco
        Role userRole = new Role();
        userRole.setName(RoleName.USER);
        try {
            roleRepository.save(userRole);
            System.out.println("ROLE_USER criado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Falha ao criar ROLE_USER: " + e.getMessage());
        }
    }

    @Test
    void testRegisterUser_Success() {
        RegisterRequestDTO registerRequest = new RegisterRequestDTO();
        registerRequest.setUsername("testuser");
        registerRequest.setEmail("testuser@example.com");
        registerRequest.setPassword("password123");
        registerRequest.setRole(RoleName.USER);

        String result = authService.registerUser(registerRequest);

        assertEquals("User registered successfully", result);

        User user = userRepository.findByUsername("testuser").orElse(null);
        assertNotNull(user);
        assertTrue(passwordEncoder.matches("password123", user.getPassword()));
        assertEquals("testuser@example.com", user.getEmail());
        assertEquals(1, user.getRoles().size());
    }

    @Test
    void testAuthenticateUser_Success() {
        // Primeiro, registra o usuário
        RegisterRequestDTO registerRequest = new RegisterRequestDTO();
        registerRequest.setUsername("authuser");
        registerRequest.setEmail("authuser@example.com");
        registerRequest.setPassword("pass123");
        registerRequest.setRole(RoleName.USER);
        authService.registerUser(registerRequest);

        // Agora autentica com sucesso
        AuthRequestDTO authRequest = new AuthRequestDTO();
        authRequest.setUsername("authuser");
        authRequest.setPassword("pass123");

        String token = authService.authenticateStr(authRequest);

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }
}
