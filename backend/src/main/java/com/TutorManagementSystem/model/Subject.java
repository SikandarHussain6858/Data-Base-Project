package com.TutorManagementSystem.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "subject")
    private List<StudentSubject> studentSubjects;

    // Add predefined subjects
    public static final String[] AVAILABLE_SUBJECTS = {
        "Mathematics", "Physics", "Biology", "Chemistry", 
        "English", "Urdu", "Basic Science"
    };

    // Getters and setters using camelCase
    public Long getSubjectId() { return subjectId; }
    public void setSubjectId(Long subjectId) { this.subjectId = subjectId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<StudentSubject> getStudentSubjects() { return studentSubjects; }
    public void setStudentSubjects(List<StudentSubject> studentSubjects) { this.studentSubjects = studentSubjects; }
}