package com.TutorManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends User {

    private String grade;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }


}
