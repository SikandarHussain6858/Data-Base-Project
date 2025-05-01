package com.TutorManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.TutorManagementSystem.model.User;
import com.TutorManagementSystem.service.UserService;
import com.TutorManagementSystem.dto.LoginRequest;
import com.TutorManagementSystem.dto.LoginResponse;
import com.TutorManagementSystem.dto.RegisterRequest;
import com.TutorManagementSystem.model.Student;
import com.TutorManagementSystem.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        try {
            // Debug logging
            System.out.println("Received registration request: " + request);

            if ("STUDENT".equals(request.getRole())) {
                // Create Student directly since it extends User
                Student student = new Student();
                student.setName(request.getName());
                student.setEmail(request.getEmail());
                student.setPassword(request.getPassword());
                student.setRole(request.getRole());
                student.setCreatedAt(LocalDateTime.now());
                student.setGrade("Not Set"); // Default grade
                
                Student savedStudent = studentRepository.save(student);
                return ResponseEntity.ok().body(savedStudent);
            } else {
                // Handle other roles (like TUTOR) with regular User
                User user = new User();
                user.setName(request.getName());
                user.setEmail(request.getEmail());
                user.setPassword(request.getPassword());
                user.setRole(request.getRole());
                user.setCreatedAt(LocalDateTime.now());
                
                User savedUser = userService.save(user);
                return ResponseEntity.ok().body(savedUser);
            }
        } catch (Exception e) {
            System.err.println("Registration error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<User> getProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}