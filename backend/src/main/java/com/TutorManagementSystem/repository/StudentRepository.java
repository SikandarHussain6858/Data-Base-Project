package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUser_Id(Long id);
    
}