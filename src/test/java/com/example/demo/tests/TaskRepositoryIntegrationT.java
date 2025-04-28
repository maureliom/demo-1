package com.example.demo.tests;

import com.example.demo.model.task.Task;
import com.example.demo.repository.task.TaskRepository;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TaskRepositoryIntegrationT {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @Rollback(false)
    void testCreateAndFindTask() {
        Task task = new Task();
        task.setTitle("Integration Test Task");
        task.setDescription("Testing DB integration");
        task.setCompleted(false);

        Task saved = taskRepository.save(task);
        assertNotNull(saved);
        assertNotNull(saved.getId());

        Task found = taskRepository.findById(saved.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("Integration Test Task", found.getTitle());
    }

    @Test
    void testFindAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        assertNotNull(tasks);
    }

    @Test
    void testSaveTask() {
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Description of the test task");

        Task savedTask = taskRepository.save(task);
        assertNotNull(savedTask.getId());
        assertEquals("Test Task", savedTask.getTitle());
    }

    @Test
    void testFindTaskById() {
        Task task = new Task();
        task.setTitle("Test Task Find");
        task.setDescription("Description for find test");

        Task savedTask = taskRepository.save(task);
        Task foundTask = taskRepository.findById(savedTask.getId()).orElse(null);

        assertNotNull(foundTask);
        assertEquals(savedTask.getId(), foundTask.getId());
    }
}
