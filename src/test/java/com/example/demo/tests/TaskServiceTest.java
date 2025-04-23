package com.example.demo.tests;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("Testing task service");
        task.setCompleted(false);
    }

    @Test
    void testCreateTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task created = taskService.createTask(task);

        assertNotNull(created);
        assertEquals("Test Task", created.getTitle());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = Arrays.asList(task);
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(1, result.size());
        assertEquals(task.getTitle(), result.get(0).getTitle());
    }

    @Test
    void testGetTaskById_Found() {
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("Testing task service");
        task.setCompleted(false);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> result = taskService.getTaskById(1L);

        assertTrue(result.isPresent());

        Task foundTask = result.get();
        assertEquals(task.getId(), foundTask.getId());
        assertEquals(task.getTitle(), foundTask.getTitle());
        assertEquals(task.getDescription(), foundTask.getDescription());
        assertEquals(task.isCompleted(), foundTask.isCompleted());
        assertEquals(task.getUser(), foundTask.getUser());
    }

    @Test
    void testGetTaskById_NotFound() {
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Task> result = taskService.getTaskById(99L);
        assertTrue(result.isEmpty());
    }

    @Test
    void testUpdateTask() {
        Task updatedTask = new Task();
        updatedTask.setId(1L);
        updatedTask.setTitle("Updated Task");
        updatedTask.setDescription("Updated Description");
        updatedTask.setCompleted(true);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        Task result = taskService.updateTask(1L, updatedTask);

        assertEquals("Updated Task", result.getTitle());
        assertTrue(result.isCompleted());
    }

    @Test
    void testDeleteTask() {
    	Long taskId = 1L;
        //when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        //doNothing().when(taskRepository).delete(task);

        taskService.deleteTask(taskId);

        verify(taskRepository, times(1)).deleteById(taskId);
    }
}
