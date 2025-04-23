package com.TutorManagementSystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tutorId;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private TutoringRequest request;

    private LocalDateTime assignedAt;

    // Constructors, getters, setters omitted for brevity
}

