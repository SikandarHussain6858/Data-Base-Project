package com.TutorManagementSystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tutoring_request")
public class StudentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long request_id;

    @Column(name = "student_id")
private Long studentId;

@Column(name = "subject_id")
private String subjectId;


    @Column(unique = true, nullable = false)
    private String description;

    @Column(unique = true, nullable = false)
    private String status;  // "PENDING" or "ASSIGNED"

    @Column(unique = true, nullable = false)
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
    public Long getRequest_id() {
        return request_id;
    }

    // Setter for id (optional, if needed)
    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}