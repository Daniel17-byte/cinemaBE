package com.example.cinemabe.controllers;

import com.example.cinemabe.models.User;
import com.example.cinemabe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProtectedDataController {
    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("/protected-data")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> getProtectedData(@RequestHeader("Authorization") String token, @RequestHeader("userName") String userName) {
        String jwtToken = token.replace("Bearer ", "");
        User user = userRepository.findUserByUserName(userName);
        String protectedData = "This is some protected data for user " + user;
        return ResponseEntity.ok(protectedData);
    }
}