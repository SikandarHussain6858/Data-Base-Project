package com.TutorManagementSystem.repository;

import java.util.List;
import com.TutorManagementSystem.model.Tutor;
import com.TutorManagementSystem.model.TutorSubject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

;

}