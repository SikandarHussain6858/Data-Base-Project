package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}

