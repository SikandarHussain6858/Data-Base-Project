package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT ts.subject FROM TutorSubject ts WHERE ts.tutor.id = :tutorId")
    List<Subject> findSubjectsByTutorId(@Param("tutorId") Long tutorId);
}

