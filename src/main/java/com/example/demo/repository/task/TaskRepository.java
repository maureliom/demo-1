package com.example.demo.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.task.Task;
import com.example.demo.model.task.User;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findByCompleted(boolean completed);
}