package com.example.demo.tests;

import com.example.demo.dto.AuthRequestDTO;
import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.model.task.Role;
import com.example.demo.model.task.RoleName;
import com.example.demo.repository.task.RoleRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.task.AuthService;

import java.util.List;

public class TestUtil {

    public static String registerAndGenerateToken(
            String username,
            String password,
            RoleName role,
            AuthService authService,
            JwtTokenProvider jwtTokenProvider
    ) {
        // Registra o usuário
        RegisterRequestDTO registerRequest = new RegisterRequestDTO();
        registerRequest.setUsername(username);
        registerRequest.setPassword(password);
        registerRequest.setRole(role);
        authService.registerUser(registerRequest);

        // Autentica e gera token
        AuthRequestDTO authRequest = new AuthRequestDTO();
        authRequest.setUsername(username);
        authRequest.setPassword(password);
        List<RoleName> roles = authService.authenticate(authRequest);

        return jwtTokenProvider.generateTokenWithRoles(username, roles);
    }
    
    public static String registerRole(
            RoleName role,
            RoleRepository roleRepository		
    ) {
    	Role userRole = new Role();
    	userRole.setName(role);
    	roleRepository.save(userRole);
    	
    	return role.toString();
    }
}
