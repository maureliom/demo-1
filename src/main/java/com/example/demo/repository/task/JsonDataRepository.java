package com.example.demo.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.task.JsonData;

public interface JsonDataRepository extends JpaRepository<JsonData, Long> {
}
