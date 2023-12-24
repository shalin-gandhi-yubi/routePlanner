package com.example.routeplanner.service;

import com.example.routeplanner.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
}
