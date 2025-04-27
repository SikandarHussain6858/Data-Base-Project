package com.TutorManagementSystem.controllers;

import com.TutorManagementSystem.model.StudentRequest;
import com.TutorManagementSystem.model.Subject;
import com.TutorManagementSystem.service.StudentRequestService;
import com.TutorManagementSystem.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student-dashboard")
public class StudentDashboardController {

    @Autowired
    private StudentRequestService studentRequestService;

    @Autowired
    private SubjectRepository subjectRepository;

    // Endpoint to get current subjects the student is learning
    @GetMapping("/current-subjects/{studentId}")
    public ResponseEntity<List<Subject>> getCurrentSubjects(@PathVariable Long studentId) {
        // Get assigned student requests for the student
        List<StudentRequest> assignedRequests = studentRequestService.getAssignedRequestsByStudentId(studentId);

        // Extract subject IDs from requests
        List<Long> subjectIds = assignedRequests.stream()
                .map(req -> {
                    try {
                        return req.getSubjectId();
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .filter(id -> id != null)
                .collect(Collectors.toList());

        // Get subject details by IDs
        List<Subject> subjects = subjectRepository.findBySubject_idIn(subjectIds);

        return ResponseEntity.ok(subjects);
    }
}
