package com.taskmanager.task_manager.model; // Line 1

import jakarta.persistence.*; // Line 3: Needed for @Entity, @Id, @Table
import lombok.Data; // Line 4: Needed for @Data
import java.time.LocalDateTime; // Line 5: Needed for created_at

// These are CLASS-LEVEL annotations, they go immediately BEFORE the class declaration
@Entity
@Table(name = "tasks")
@Data
public class Task { // <-- Start of the class (Line ~10)

    // These are FIELD-LEVEL annotations, they go immediately BEFORE the field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Line 13 should be around here or slightly below

    @Column(nullable = false)
    private String title;

    @Lob
    private String description;

    private String status = "Pending";

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

} // <-- End of the class