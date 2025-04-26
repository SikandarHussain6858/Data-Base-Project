package com.TutorManagementSystem.service;

import com.TutorManagementSystem.model.StudentRequest;
import com.TutorManagementSystem.repository.StudentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentRequestService {

    @Autowired
    private StudentRequestRepository studentRequestRepository;

    // Get all student requests
    public List<StudentRequest> getAllRequests() {
        return studentRequestRepository.findAll();
    }

    // Get a single request by ID
    public Optional<StudentRequest> getRequestById(Long id) {
        return studentRequestRepository.findById(id);
    }

    // Create a new student request
    public StudentRequest createRequest(StudentRequest request) {
        return studentRequestRepository.save(request);
    }

    // Update an existing request
    public StudentRequest updateRequest(Long id, StudentRequest updatedRequest) {
        Optional<StudentRequest> existingRequestOpt = studentRequestRepository.findById(id);

        if (existingRequestOpt.isPresent()) {
            StudentRequest existingRequest = existingRequestOpt.get();
            existingRequest.setStudentId(updatedRequest.getStudentId());
            existingRequest.setSubjectId(updatedRequest.getSubjectId());
            existingRequest.setDescription(updatedRequest.getDescription());
            existingRequest.setStatus(updatedRequest.getStatus());
            existingRequest.setCreatedAt(updatedRequest.getCreatedAt());

            return studentRequestRepository.save(existingRequest);
        } else {
            throw new RuntimeException("Request with ID " + id + " not found.");
        }
    }

    // Delete a request
    public void deleteRequest(Long id) {
        studentRequestRepository.deleteById(id);
    }
}
