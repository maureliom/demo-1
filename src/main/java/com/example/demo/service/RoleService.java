package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.RoleName;
import com.example.demo.model.Task;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService { 

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByName(RoleName name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Role not found: " + name));
    }
}