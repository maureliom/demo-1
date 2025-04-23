package com.example.demo.tests;

import com.example.demo.security.JwtTokenProvider;
import com.example.demo.model.User;
import com.example.demo.model.Role;
import com.example.demo.model.RoleName;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.RoleRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecurityIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private String userToken;

    @BeforeAll
    void setupUserAndToken() {
        Role roleUser = roleRepository.findByName(RoleName.USER)
                .orElseGet(() -> roleRepository.save(new Role("USER"))); 

        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("encoded-password"); // use um PasswordEncoder real se quiser testar autenticação
        user.setRoles(Set.of(roleUser));
        userRepository.save(user);

        userToken = jwtTokenProvider.generateTokenWithRoles(user.getUsername(), List.of("USER"));
    }

    @Test
    void testAccessWithValidToken_ShouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/tasks")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + userToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()); // ou .isNoContent() dependendo do endpoint
    }
}
