package com.example.demo.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.task.Role;
import com.example.demo.model.task.RoleName;
import com.example.demo.model.task.User;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}