package com.example.demo.tests;
import com.example.demo.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.TaskRepository;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TaskRepositoryIntegrationTest {

	@Autowired
    private TaskRepository taskRepository;

    @Test
    @Rollback(false) // Remove isso se quiser que o teste reverta mudanças após rodar
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
        assertTrue(tasks.size() >= 0); // Pode ser vazio, mas não deve ser nulo
    }
    
    @Test
    public void testSaveTask() {
        // Criação de uma nova Task
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("Description of the test task");

        // Salvando a Task
        Task savedTask = taskRepository.save(task);

        // Verificando se a Task foi salva corretamente
        assertNotNull(savedTask.getId());
        assertEquals("Test Task", savedTask.getTitle());
    }

    @Test
    public void testFindTaskById() {
        // Criando e salvando uma Task
        Task task = new Task();
        task.setTitle("Test Task Find");
        task.setDescription("Description for find test");
        Task savedTask = taskRepository.save(task);

        // Buscando pela Task salva
        Task foundTask = taskRepository.findById(savedTask.getId()).orElse(null);

        // Verificando se a Task foi encontrada
        assertNotNull(foundTask);
        assertEquals(savedTask.getId(), foundTask.getId());
    }
}