package com.TutorManagementSystem.model;

import java.util.List;
import jakarta.persistence.*;
import java.util.Set;
import com.TutorManagementSystem.model.Subject;

@Entity
@Table(name = "tutor")
public class Tutor extends User {
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "tutor")
    private List<TutorSubject> tutorSubjects;

    private String specialization;
    private String qualifications;

    @ManyToMany
    @JoinTable(
        name = "tutor_subject",
        joinColumns = @JoinColumn(name = "tutor_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )

    // Getters and setters
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    
    public String getQualifications() { return qualifications; }
    public void setQualifications(String qualifications) { this.qualifications = qualifications; }
    
    public List<TutorSubject> getTutorSubjects() { return tutorSubjects; }
    public void setTutorSubjects(List<TutorSubject> tutorSubjects) { this.tutorSubjects = tutorSubjects; }
}