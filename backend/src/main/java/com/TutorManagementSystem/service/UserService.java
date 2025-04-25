package com.TutorManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TutorManagementSystem.model.User;
import com.TutorManagementSystem.repository.UserRepository;
import com.TutorManagementSystem.dto.LoginResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
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
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
}