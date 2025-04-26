package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.StudentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRequestRepository extends JpaRepository<StudentRequest, Long> {

    // You can find requests by subject id (optional)
    List<StudentRequest> findBySubjectId(String subjectId);


    // Find all requests by status
    List<StudentRequest> findByStatus(String status);


    

    // Find all requests by student id
    List<StudentRequest> findByStudentId(Long studentId);


}



