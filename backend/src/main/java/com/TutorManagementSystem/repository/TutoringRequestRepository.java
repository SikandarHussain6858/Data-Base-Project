package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.TutoringRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutoringRequestRepository extends JpaRepository<TutoringRequest, Long> {
}