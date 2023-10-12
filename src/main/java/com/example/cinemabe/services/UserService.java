package com.example.cinemabe.services;

import com.example.cinemabe.login.CustomAuthentication;
import com.example.cinemabe.models.User;
import com.example.cinemabe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Authentication authenticateUser(String userName, String password) {
        User user = userRepository.findUserByUserName(userName);

        if (user == null) {
            return new CustomAuthentication(user, "User not found.");
        }

        if (!user.getPassword().equals(password)) {
            return new CustomAuthentication(user, "Incorrect password.");
        }

        return new CustomAuthentication(user, "Authentication successful.");
    }
}