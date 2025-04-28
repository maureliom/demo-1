package com.example.demo.tests;

import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.task.AuthService;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.model.task.RoleName;
import com.example.demo.repository.task.RoleRepository;
import com.example.demo.repository.task.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
public class UserT {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private  AuthService authService;

    @Test
    @Rollback(false)
    void setupUserAndToken() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        
    	String roleAdmin = TestUtil.registerRole(RoleName.ADMIN, roleRepository);
    	String roleUser = TestUtil.registerRole(RoleName.USER, roleRepository);
    	
        String tokenUser = TestUtil.registerAndGenerateToken(
            "john", "123456", RoleName.USER, authService, jwtTokenProvider
        );

        String tokenAdmin = TestUtil.registerAndGenerateToken(
            "admin", "123456", RoleName.ADMIN, authService, jwtTokenProvider
        );

        // Agora você pode usar tokenUser ou tokenAdmin nos headers dos testes
        log.info("Token USER: {}", tokenUser);
        log.info("Token ADMIN: {}", tokenAdmin);
    }
}
