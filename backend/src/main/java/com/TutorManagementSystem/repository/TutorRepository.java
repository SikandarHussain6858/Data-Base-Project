package com.TutorManagementSystem.repository;

import java.util.List;
import java.util.Optional;
import com.TutorManagementSystem.model.Tutor;
import com.TutorManagementSystem.model.TutorSubject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    @Query("SELECT DISTINCT t FROM Tutor t " +
           "LEFT JOIN FETCH t.tutorSubjects ts " +
           "LEFT JOIN FETCH ts.subject " +
           "WHERE ts.subject.id = :subjectId")
    List<Tutor> findBySubjectsId(@Param("subjectId") Long subjectId);

    @Query("SELECT t FROM Tutor t " +
           "LEFT JOIN FETCH t.tutorSubjects ts " +
           "LEFT JOIN FETCH ts.subject " +
           "WHERE t.id = :tutorId")
    Optional<Tutor> findByIdWithSubjects(@Param("tutorId") Long tutorId);
}