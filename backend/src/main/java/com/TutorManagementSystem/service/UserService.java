package com.TutorManagementSystem.service;

import com.TutorManagementSystem.dto.LoginResponse;
import com.TutorManagementSystem.dto.RegisterRequest;
import com.TutorManagementSystem.model.User;
import com.TutorManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(String email, String password) {
        // Find user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }

        // Check if password matches
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }

        // Create LoginResponse
        LoginResponse response = new LoginResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());

        return response;
    }

    // Existing methods in UserService

    public User findById(Long id) {
    // Implement the logic to find a user by ID
    // For example, if you are using a repository:
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    
    public User register(RegisterRequest registerRequest) {
        // Create a new User
        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword()); // Normally you should hash this!
        user.setRole(registerRequest.getRole());
        user.setCreatedAt(java.time.LocalDateTime.now()); // Assuming you have createdAt in User model
        
        // Save User
        return userRepository.save(user);
    }
}
