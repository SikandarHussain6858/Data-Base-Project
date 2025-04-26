package com.TutorManagementSystem.repository;

import com.TutorManagementSystem.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByTutorId(Long tutorId);
}
