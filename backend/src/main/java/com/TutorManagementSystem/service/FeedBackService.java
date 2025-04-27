package com.TutorManagementSystem.service;

import com.TutorManagementSystem.model.RatingFeedback;
import com.TutorManagementSystem.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import com.TutorManagementSystem.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.TutorManagementSystem.model.Job;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedBackService {
    @Autowired
    private FeedbackRepository repo;

    /**
     * Records a piece of feedback:
     *  - Stamps it with the current time
     *  - Saves it to the DB
     */
    public RatingFeedback submitFeedback(RatingFeedback feedback) {
        feedback.setSubmittedAt(LocalDateTime.now());
        return repo.save(feedback);
    }

    /**
     * Retrieves all feedback entries linked to the given tutor.
     */
    public List<RatingFeedback> getFeedbackByJobId(Long jobId) {
        return repo.findByJobJobId(jobId);
    }
    
}