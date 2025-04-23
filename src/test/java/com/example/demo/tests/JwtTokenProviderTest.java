package com.example.demo.tests;

import com.example.demo.security.JwtTokenProvider;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenProviderTest {

    private JwtTokenProvider jwtTokenProvider;
    private final String secret = "mySuperSecretKeyForJwtGenerationThatIsLongEnough123456";
    private final long expiration = 3600000; // 1h

    @BeforeEach
    void setUp() {
        jwtTokenProvider = new JwtTokenProvider(secret, expiration);
    }

    @Test
    void testGenerateToken_ValidUser() {
        String token = jwtTokenProvider.generateToken("testUser");
        assertNotNull(token);
    }

    @Test
    void testGetUsernameFromJWT_ValidToken() {
        String token = jwtTokenProvider.generateToken("testUser");
        String username = jwtTokenProvider.getUsernameFromJWT(token);
        assertEquals("testUser", username);
    }

    @Test
    void testValidateToken_Valid() {
        String token = jwtTokenProvider.generateToken("testUser");
        assertTrue(jwtTokenProvider.validateToken(token));
    }

    @Test
    void testValidateToken_Invalid() {
        String invalidToken = "invalid.jwt.token";
        assertFalse(jwtTokenProvider.validateToken(invalidToken));
    }
}
