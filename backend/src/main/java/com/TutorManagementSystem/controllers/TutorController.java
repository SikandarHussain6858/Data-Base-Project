package com.TutorManagementSystem.controllers;

import com.TutorManagementSystem.model.StudentRequest;
import com.TutorManagementSystem.service.StudentRequestService;
import com.TutorManagementSystem.service.TutorSubjectService;
import com.TutorManagementSystem.model.TutorSubject;
import com.TutorManagementSystem.model.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tutor")
@CrossOrigin(origins = "*") // Allow frontend calls (optional but helpful during testing)
public class TutorController {

    @Autowired
    private StudentRequestService studentRequestService;

    // In-memory lists for slots and subjects (for now)
    private final List<String> availableSlots = new java.util.ArrayList<>();
    private final List<String> subjects = new java.util.ArrayList<>();

    // 1️⃣ Add available slot
    @PostMapping("/add-availability")
    public void addAvailability(@RequestBody Map<String, String> body) {
        String slot = body.get("slot");
        if (slot != null && !slot.isEmpty()) {
            availableSlots.add(slot);
        }
    }

    // 2️⃣ Add subject
    @PostMapping("/add-subject")
    public void addSubject(@RequestBody Map<String, String> body) {
        String subject = body.get("subject");
        if (subject != null && !subject.isEmpty()) {
            subjects.add(subject.toLowerCase()); // lowercased for matching
        }
    }

    // 3️⃣ Get student requests that match tutor's subjects
    @GetMapping("/requests")
    public List<StudentRequest> getMatchingStudentRequests() {
        List<StudentRequest> allRequests = studentRequestService.getAllRequests();
        return allRequests.stream()
                .filter(request -> 
                    subjects.contains(request.getSubjectId().toLowerCase()) 
                    && "PENDING".equalsIgnoreCase(request.getStatus())
                )
                .toList();
    }

    @Autowired
    private TutorSubjectService tutorSubjectService;

    @GetMapping("/{tutorId}/subjects")
public List<Subject> getSubjectsByTutorId(@PathVariable Long tutorId) {
    return tutorSubjectService.getSubjectsByTutorId(tutorId);
}

}
