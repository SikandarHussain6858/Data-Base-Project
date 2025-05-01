package com.TutorManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.TutorManagementSystem.model.Subject;
import com.TutorManagementSystem.model.Tutor;
import com.TutorManagementSystem.repository.SubjectRepository;
import com.TutorManagementSystem.repository.TutorRepository;
import com.TutorManagementSystem.service.TutorService;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private TutorService tutorService;

    // GET /subjects → Return list of available subjects
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return ResponseEntity.ok(subjectRepository.findAll());
    }

    // GET /tutors?subject=math → Return tutors for that subject
    @GetMapping("/tutors")
    public ResponseEntity<List<Tutor>> getTutorsBySubject(@RequestParam String subject) {
        Subject subj = subjectRepository.findByNameIgnoreCase(subject)
            .orElseThrow(() -> new RuntimeException("Subject not found: " + subject));
        return ResponseEntity.ok(tutorRepository.findBySubjectsId(subj.getSubjectId()));
    }

    // GET /tutor/{tutor_id} → Return full tutor profile + availability
    @GetMapping("/tutor/{tutorId}")
    public ResponseEntity<Map<String, Object>> getTutorProfile(@PathVariable Long tutorId) {
        Map<String, Object> profile = new HashMap<>();
        
        Tutor tutor = tutorRepository.findById(tutorId)
            .orElseThrow(() -> new RuntimeException("Tutor not found"));
            
        profile.put("tutor", tutor);
        profile.put("subjects", tutorService.getSubjectsForTutor(tutorId));
        profile.put("availability", tutorService.getAvailabilityForTutor(tutorId));
        
        return ResponseEntity.ok(profile);
    }
}