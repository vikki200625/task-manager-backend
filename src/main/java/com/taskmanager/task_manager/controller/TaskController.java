package com.taskmanager.task_manager.controller;

import com.taskmanager.task_manager.model.Task;
import com.taskmanager.task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks") // Base URL for all endpoints in this class
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // =========================================================
    // 1. CREATE (POST) - /api/tasks
    // =========================================================
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {

        // Validation check: Title is required (BRD)
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Task savedTask = taskRepository.save(task);

        // Return 201 Created status
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    // =========================================================
    // 2. READ ALL (GET) - /api/tasks
    // =========================================================
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // =========================================================
    // 3. UPDATE (PUT) - /api/tasks/{id}
    // =========================================================
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {

        // Attempt to find the existing task
        Task task = taskRepository.findById(id)
                .orElse(null);

        if (task == null) {
            // Return 404 Not Found if the ID does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Apply updates only if the corresponding field is provided in the request body
        if (taskDetails.getTitle() != null && !taskDetails.getTitle().trim().isEmpty()) {
            task.setTitle(taskDetails.getTitle());
        }

        if (taskDetails.getDescription() != null) {
            task.setDescription(taskDetails.getDescription());
        }

        // This handles "Mark as Done" or status change
        if (taskDetails.getStatus() != null) {
            task.setStatus(taskDetails.getStatus());
        }

        Task updatedTask = taskRepository.save(task);

        // Return 200 OK status with the updated object
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // =========================================================
    // 4. DELETE (DELETE) - /api/tasks/{id}
    // =========================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {

        // Note: Spring Data JPA's deleteById often handles non-existent IDs gracefully
        // without requiring an explicit check, but we could add one if needed.
        taskRepository.deleteById(id);

        // Return 204 No Content, indicating success without a response body
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}