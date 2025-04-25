package com.TutorManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TutorManagementSystem.model.*;
import com.TutorManagementSystem.repository.*;
import com.TutorManagementSystem.dto.LoginResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private TutorRepository tutorRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(User user) {
        // Validate required fields
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new RuntimeException("Name is required");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Email is required");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password is required");
        }
        if (user.getRole() == null || user.getRole().trim().isEmpty()) {
            throw new RuntimeException("Role is required");
        }

        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // Hash password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Save user
        try {
            user = userRepository.save(user);
            
            // Create student/tutor record
            if ("STUDENT".equals(user.getRole())) {
                Student student = new Student();
                student.setUser(user);
                studentRepository.save(student);
            } else if ("TUTOR".equals(user.getRole())) {
                Tutor tutor = new Tutor();
                tutor.setUser(user);
                tutorRepository.save(tutor);
            }
            
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    public LoginResponse login(String email, String password) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
            
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getId());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setName(user.getName());
        return response;
    }

    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}