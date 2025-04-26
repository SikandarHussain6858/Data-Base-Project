package com.TutorManagementSystem.dto;

public class AvailabilityDTO {
    private Long availability_id;
    private String dayOfWeek;
    private String startTime;
    private String endTime;


    // Constructors
    public AvailabilityDTO() {}
    public AvailabilityDTO(Long availability_id, String dayOfWeek, String startTime, String endTime) {
        this.availability_id = availability_id;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    // Getters and setters
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

}
