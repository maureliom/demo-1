package com.example.demo.service.task;

import com.example.demo.model.task.Role;
import com.example.demo.model.task.RoleName;
import com.example.demo.model.task.Task;
import com.example.demo.repository.task.RoleRepository;

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