package com.TutorManagementSystem.dto;

import java.time.LocalTime;

public class AvailabilityDTO {
    private Long availabilityId;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public AvailabilityDTO() {}
    public AvailabilityDTO(Long availabilityId, String dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.availabilityId = availabilityId;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and setters
    public Long getAvailabilityId() { return availabilityId; }
    public void setAvailabilityId(Long availabilityId) { this.availabilityId = availabilityId; }

    public String getDayOfWeek() { return dayOfWeek; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
}
