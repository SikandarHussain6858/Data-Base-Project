package com.TutorManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TutorManagementSystem.model.Feedback;
import com.TutorManagementSystem.service.FeedBackService;
import com.TutorManagementSystem.service.TutoringRequestService;
import com.TutorManagementSystem.model.TutoringRequest;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TutoringRequestController {

    @Autowired
    private TutoringRequestService requestService;

    // POST /student-request → Add a new tutoring request
    @PostMapping("/student-request")
    public ResponseEntity<TutoringRequest> createRequest(@RequestBody TutoringRequest request) {
        return ResponseEntity.ok(requestService.saveRequest(request));
    }

    // GET /student-request/status/{id} → Return status for a request
    @GetMapping("/student-request/status/{id}")
    public ResponseEntity<String> getStatus(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.getStatusById(id));
    }
}
