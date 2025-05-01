package com.TutorManagementSystem.controllers;

import com.TutorManagementSystem.model.Subject;
import com.TutorManagementSystem.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-dashboard")
public class StudentDashboardController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/current-subjects/{studentId}")
    public ResponseEntity<List<Subject>> getCurrentSubjects(@PathVariable Long studentId) {
        try {
            // Use proper method name matching the Subject entity
            List<Subject> subjects = subjectRepository.findByStudentId(studentId);
            
            if (subjects.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(subjects);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/subjects/{ids}")
    public ResponseEntity<List<Subject>> getSubjectsByIds(@PathVariable List<Long> ids) {
        try {
            // Use proper method name matching the Subject entity
            List<Subject> subjects = subjectRepository.findBySubjectIdIn(ids);
            return ResponseEntity.ok(subjects);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
