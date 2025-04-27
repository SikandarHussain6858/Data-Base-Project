package com.TutorManagementSystem.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(unique = true, nullable = false)
    private Long subject_id;

    @OneToMany(mappedBy = "subject")
    private List<TutorSubject> tutorSubjects;
    
    @Column(unique = true, nullable = false)
    private String subjectName;
    private String description;

    // Getters and setters
    public Long getSubject_id() { return subject_id; }
    public void setSubject_id(Long subject_id) { this.subject_id = subject_id; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
    

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}