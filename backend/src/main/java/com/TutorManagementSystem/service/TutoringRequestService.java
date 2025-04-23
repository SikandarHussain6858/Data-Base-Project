package com.TutorManagementSystem.service;


import com.TutorManagementSystem.models.TutoringRequest;
import com.TutorManagementSystem.repositories.TutoringRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@Service
public class TutoringRequestService {
    @Autowired
    private TutoringRequestRepository repo;

    /**
     * Creates a new tutoring request:
     *  - Sets status = "PENDING"
     *  - Records creation timestamp
     *  - Saves to DB
     */
    public TutoringRequest saveRequest(TutoringRequest request) {
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDateTime.now());
        return repo.save(request);
    }

    /**
     * Looks up a request by its ID and returns its status,
     * or "NOT_FOUND" if it doesn’t exist.
     */
    public String getStatusById(Long id) {
        return repo.findById(id)
            .map(TutoringRequest::getStatus)
            .orElse("NOT_FOUND");
    }
}