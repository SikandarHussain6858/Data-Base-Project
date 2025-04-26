package com.TutorManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tutor_subject")
public class TutorSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorSubjectId;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    private String experience;

    // Getters and Setters
    public Long getTutorSubjectId() { return tutorSubjectId; }
    public void setTutorSubjectId(Long tutorSubjectId) { this.tutorSubjectId = tutorSubjectId; }

    public Tutor getTutor() { return tutor; }
    public void setTutor(Tutor tutor) { this.tutor = tutor; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }
}
