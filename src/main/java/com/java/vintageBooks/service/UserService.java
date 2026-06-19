package com.java.vintageBooks.service;

import com.java.vintageBooks.entity.User;
import com.java.vintageBooks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}