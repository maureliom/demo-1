package com.example.demo.service.task;

import com.example.demo.dto.AuthRequestDTO;
import com.example.demo.dto.RegisterRequestDTO;
import com.example.demo.model.task.Role;
import com.example.demo.model.task.RoleName;
import com.example.demo.model.task.User;
import com.example.demo.repository.task.RoleRepository;
import com.example.demo.repository.task.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String registerUser(RegisterRequestDTO request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already taken");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role role = roleRepository.findByName(request.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.getRoles().add(role);

        userRepository.save(user);
        System.out.println("Usuário registrado com sucesso: {} =  "+user.getPassword());
        log.info("Usuário registrado com sucesso: {}", user.getUsername());

        return "User registered successfully";
    }

    public List<RoleName> authenticate(AuthRequestDTO request) {
    	log.info("a buscar por: "+request.getUsername());
    	
        User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        log.info("resultado da busca: "+user.getId());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        	log.info(request.getPassword(), user.getPassword());
            throw new BadCredentialsException("Senha inválida " + request.getPassword()+" - "+ user.getPassword());
        }

        // Retorna lista de roles para o controller gerar o token
        return user.getRoles()
                   .stream()
                   .map(Role::getName)
                   .collect(Collectors.toList());
    }

}
