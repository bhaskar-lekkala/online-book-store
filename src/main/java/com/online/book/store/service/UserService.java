package com.online.book.store.service;

import com.online.book.store.entity.User;
import com.online.book.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void registerUser(User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER"); // Set default role
        userRepository.save(user);
    }

    public String login(User user) {
        User userData = userRepository.findByUsername(user.getUsername());
        if (passwordEncoder.matches(user.getPassword(), userData.getPassword())) {
            return "Success";
        }
        return "Error";
    }
}
