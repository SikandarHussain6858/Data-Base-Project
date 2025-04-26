package com.TutorManagementSystem.service;

import com.TutorManagementSystem.dto.AvailabilityDTO;
import com.TutorManagementSystem.service.StudentRequestService;
import com.TutorManagementSystem.dto.SubjectDTO;
import com.TutorManagementSystem.dto.StudentRequestDTO;
import com.TutorManagementSystem.model.*;
import com.TutorManagementSystem.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorService {

    private final SubjectRepository subjectRepository;
    private final AvailabilityRepository availabilityRepository;
    private final StudentRequestRepository studentRequestRepository;
    private final UserRepository userRepository;

    public TutorService(SubjectRepository subjectRepository, AvailabilityRepository availabilityRepository, StudentRequestRepository studentRequestRepository, UserRepository userRepository) {
        this.subjectRepository = subjectRepository;
        this.availabilityRepository = availabilityRepository;
        this.studentRequestRepository = studentRequestRepository;
        this.userRepository = userRepository;
    }

    // Get all subjects for a tutor
    public List<SubjectDTO> getSubjectsForTutor(Long tutorId) {
        return subjectRepository.findByTutorId(tutorId)
                .stream()
                .map(subject -> new SubjectDTO(subject.getSubject_id(), subject.getSubjectName(), subject.getDescription()))
                .collect(Collectors.toList());
    }

    // Get all availability slots for a tutor
    public List<AvailabilityDTO> getAvailabilityForTutor(Long tutorId) {
        return availabilityRepository.findByTutorId(tutorId)
                .stream()
                .map(avail -> new AvailabilityDTO(avail.getAvailability_id(), avail.getDayOfWeek(), avail.getStartTime(), avail.getEndTime()))
                .collect(Collectors.toList());
    }

    // Get all student requests for a tutor
    public List<StudentRequestDTO> getRequestsForTutor(Long tutorId) {
        // Fetch all pending requests
        List<StudentRequest> requests = studentRequestRepository.findByStatus("PENDING");
    
        return requests.stream()
    .map(request -> {
        User student = userRepository.findById(request.getStudentId())
            .orElse(new User());
            Subject subject = subjectRepository.findById(Long.parseLong(request.getSubjectId()))
            .orElse(new Subject());
        

        return new StudentRequestDTO(
            request.getRequest_id(),
            student.getName(), // Use getName() from User
            subject.getSubjectName(),
            request.getStatus()
        );
    })
    .collect(Collectors.toList());

    }
    
}
