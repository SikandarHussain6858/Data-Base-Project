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

    public TutoringRequest getRequest() {
        return request;
    }

    public void setRequest(TutoringRequest request) {
        this.request = request;
    }

    private LocalDateTime assignedAt;

    // Constructors, getters, setters omitted for brevity
    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id (optional, if needed)
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
}

