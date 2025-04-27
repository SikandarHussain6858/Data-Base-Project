package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
<<<<<<< HEAD

    @Query("SELECT ts.subject FROM TutorSubject ts WHERE ts.tutor.id = :tutorId")
    List<Subject> findSubjectsByTutorId(@Param("tutorId") Long tutorId);
}
=======
    List<Subject> findByTutorId(Long tutorId);

    // Find subjects by a list of subject IDs
    List<Subject> findBySubject_idIn(List<Long> subjectIds);
}
>>>>>>> c4800b946a04b47609d7add41d31f417c1500cb8
