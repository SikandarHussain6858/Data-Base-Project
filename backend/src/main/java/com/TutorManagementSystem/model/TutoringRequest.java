package com.TutorManagementSystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tutoring_request")
public class TutoringRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String subject;
    private String description;
    private String status;  // "PENDING" or "ASSIGNED"
    private LocalDateTime createdAt;

    // Constructors, getters, setters omitted for brevity
}