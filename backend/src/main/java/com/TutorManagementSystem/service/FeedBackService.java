package com.TutorManagementSystem.service;

import com.TutorManagementSystem.models.Feedback;
import com.TutorManagementSystem.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository repo;

    /**
     * Records a piece of feedback:
     *  - Stamps it with the current time
     *  - Saves it to the DB
     */
    public Feedback submitFeedback(Feedback feedback) {
        feedback.setSubmittedAt(LocalDateTime.now());
        return repo.save(feedback);
    }

    /**
     * Retrieves all feedback entries linked to the given tutor.
     */
    public List<Feedback> getFeedbackByTutorId(Long tutorId) {
        return repo.findByJob_TutorId(tutorId);
    }
}