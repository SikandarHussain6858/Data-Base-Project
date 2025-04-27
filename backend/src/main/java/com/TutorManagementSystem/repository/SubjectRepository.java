package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByTutorId(Long tutorId);

    // Find subjects by a list of subject IDs
    List<Subject> findBySubject_idIn(List<Long> subjectIds);
}
