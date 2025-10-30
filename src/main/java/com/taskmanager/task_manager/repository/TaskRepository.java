package com.taskmanager.task_manager.repository; // <-- Line 1 (Make sure this package name is right)

import com.taskmanager.task_manager.model.Task; // <-- Line 3 (Importing the Task Model)

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Line 12: Now Task is recognized because it was imported!
public interface TaskRepository extends JpaRepository<Task, Long> {
    // ...
}