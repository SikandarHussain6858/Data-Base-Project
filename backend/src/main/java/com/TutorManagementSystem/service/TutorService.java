package com.TutorManagementSystem.service;

import com.TutorManagementSystem.dto.AvailabilityDTO;
import com.TutorManagementSystem.dto.SubjectDTO;
import com.TutorManagementSystem.dto.StudentRequestDTO;
import com.TutorManagementSystem.model.*;
import com.TutorManagementSystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorService {

    private final SubjectRepository subjectRepository;
    private final AvailabilityRepository availabilityRepository;
    private final StudentRequestRepository studentRequestRepository;
    private final UserRepository userRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public TutorService(SubjectRepository subjectRepository, 
                       AvailabilityRepository availabilityRepository, 
                       StudentRequestRepository studentRequestRepository, 
                       UserRepository userRepository) {
        this.subjectRepository = subjectRepository;
        this.availabilityRepository = availabilityRepository;
        this.studentRequestRepository = studentRequestRepository;
        this.userRepository = userRepository;
    }

    // Get all subjects for a tutor
    public List<SubjectDTO> getSubjectsForTutor(Long tutorId) {
        return subjectRepository.findSubjectsByTutorId(tutorId)
                .stream()
                .map(subject -> new SubjectDTO(
                    subject.getSubjectId(),  // Changed from getSubject_id
                    subject.getName(),       // Changed from getSubjectName
                    subject.getDescription()
                ))
                .collect(Collectors.toList());
    }

    // Get all availability slots for a tutor
    public List<AvailabilityDTO> getAvailabilityForTutor(Long tutorId) {
        return availabilityRepository.findByTutorId(tutorId)
                .stream()
                .map(avail -> new AvailabilityDTO(
                    avail.getAvailabilityId(),  // Make sure these match your Availability entity
                    avail.getDayOfWeek(),
                    avail.getStartTime(),
                    avail.getEndTime()
                ))
                .collect(Collectors.toList());
    }

    // Get all student requests for a tutor
    public List<StudentRequestDTO> getRequestsForTutor(Long tutorId) {
        List<StudentRequest> requests = studentRequestRepository.findPendingRequests();
        return requests.stream()
                .map(request -> {
                    User student = userRepository.findById(request.getStudentId())
                            .orElse(new User());
                    Subject subject = subjectRepository.findById(request.getSubjectId())
                            .orElse(new Subject());
                    return new StudentRequestDTO(
                            request.getRequestId(),
                            student.getName(),
                            subject.getName(),  // Changed from getSubjectName
                            request.getStatus()
                    );
                })
                .collect(Collectors.toList());
    }

    // Find tutors by subject
    public List<Tutor> findTutorsBySubject(Subject subject) {
        return tutorRepository.findBySubjectsId(subject.getSubjectId());
    }

    // Get subjects taught by a tutor
    public List<Subject> getTutorSubjects(Long tutorId) {
        return tutorRepository.findById(tutorId)
                .map(tutor -> tutor.getTutorSubjects().stream()
                        .map(TutorSubject::getSubject)
                        .toList())
                .orElseThrow(() -> new RuntimeException("Tutor not found"));
    }
}
