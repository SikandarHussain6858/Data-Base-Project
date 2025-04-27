package com.TutorManagementSystem.service;
import java.util.List;

import com.TutorManagementSystem.model.Job;
import com.TutorManagementSystem.repository.JobRepository;
import com.TutorManagementSystem.repository.StudentRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private StudentRequestRepository requestRepo;

    /**
     * Assigns a tutor to an existing request:
     *  - Updates the request’s status to "ASSIGNED"
     *  - Sets the job’s assignment timestamp
     *  - Saves both entities to the DB
     */
    public Job assignJob(Job job) {
        // Mark the linked request as assigned
        requestRepo.findById(job.getRequest().getRequestId()).ifPresent(req -> {
            req.setStatus("ASSIGNED");
            requestRepo.save(req);
        });

        job.setAssignedAt(LocalDateTime.now());
        return jobRepo.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepo.findAll(); // fetch all jobs from DB
    }
}