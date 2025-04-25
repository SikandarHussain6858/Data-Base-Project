package com.TutorManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TutorManagementSystem.model.Feedback;
import com.TutorManagementSystem.service.FeedBackService;
import com.TutorManagementSystem.service.JobService;
import com.TutorManagementSystem.model.Job;

@RestController
@RequestMapping("/api")
public class JobController {



    @Autowired
    private JobService jobService;

    // GET /jobs → Get all jobs
@GetMapping("/jobs")
public ResponseEntity<List<Job>> getAllJobs() {
    return ResponseEntity.ok(jobService.getAllJobs());
}


    // POST /job → Tutor accepts a request (assign job)
    @PostMapping("/job")
    public ResponseEntity<Job> assignJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.assignJob(job));
    }
}