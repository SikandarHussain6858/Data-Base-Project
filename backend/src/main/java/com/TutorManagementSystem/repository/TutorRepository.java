package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Tutor findByUserId(Long userId);
}