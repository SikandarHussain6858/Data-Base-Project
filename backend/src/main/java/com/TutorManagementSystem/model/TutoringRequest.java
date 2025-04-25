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

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id (optional, if needed)
    public void setId(Long id) {
        this.id = id;
    }
}