package com.TutorManagementSystem.model;

import jakarta.persistence.*;

@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availability_id;

    @Column(nullable = false)
    private String dayOfWeek;

    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private User tutor;

    // Getters and setters...
    public Long getAvailability_id() {
        return availability_id;
    }
    public void setAvailability_id(Long availability_id) {
        this.availability_id = availability_id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public User getTutor() {
        return tutor;
    }
    public void setTutor(User tutor) {
        this.tutor = tutor;
    }
}
