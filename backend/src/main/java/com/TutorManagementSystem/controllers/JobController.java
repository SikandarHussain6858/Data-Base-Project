package com.TutorManagementSystem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TutorManagementSystem.model.Feedback;
import com.TutorManagementSystem.service.FeedbackService;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobService jobService;

    // POST /job → Tutor accepts a request (assign job)
    @PostMapping("/job")
    public ResponseEntity<Job> assignJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.assignJob(job));
    }
}