package com.TutorManagementSystem.service;

import com.TutorManagementSystem.models.Job;
import com.TutorManagementSystem.repositories.JobRepository;
import com.TutorManagementSystem.repositories.TutoringRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private TutoringRequestRepository requestRepo;

    /**
     * Assigns a tutor to an existing request:
     *  - Updates the request’s status to "ASSIGNED"
     *  - Sets the job’s assignment timestamp
     *  - Saves both entities to the DB
     */
    public Job assignJob(Job job) {
        // Mark the linked request as assigned
        requestRepo.findById(job.getRequest().getId()).ifPresent(req -> {
            req.setStatus("ASSIGNED");
            requestRepo.save(req);
        });

        job.setAssignedAt(LocalDateTime.now());
        return jobRepo.save(job);
    }
}