package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Remove the findById method since it's already provided by JpaRepository
    // with the correct return type Optional<Student>
}