package com.example.cinemabe.controllers;

import com.example.cinemabe.login.JwtResponse;
import com.example.cinemabe.login.JwtUtils;
import com.example.cinemabe.login.LoginRequest;
import com.example.cinemabe.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3001")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = userService.authenticateUser(loginRequest.getUserName(), loginRequest.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = JwtUtils.generateToken(authentication);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}