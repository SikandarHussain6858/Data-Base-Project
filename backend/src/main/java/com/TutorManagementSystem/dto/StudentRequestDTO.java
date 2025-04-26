package com.TutorManagementSystem.dto;

public class StudentRequestDTO {
    private Long request_id;
    private String studentName;
    private String subjectRequested;
    private String status;

    // Constructors
    public StudentRequestDTO() {}
    public StudentRequestDTO(Long request_id, String studentName, String subjectRequested, String status) {
        this.request_id = request_id;
        this.studentName = studentName;
        this.subjectRequested = subjectRequested;
        this.status = status;
    }

    // Getters and setters
    public Long getRequest_id() {
        return request_id;
    }
    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectRequested() {
        return subjectRequested;
    }
    public void setSubjectRequested(String subjectRequested) {
        this.subjectRequested = subjectRequested;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
