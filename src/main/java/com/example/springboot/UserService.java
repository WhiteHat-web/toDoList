package com.example.springboot;

import com.example.springboot.controller.UserRegistrationException;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public void registerUser(User user) {
//    }
//}

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;



    public void registerUser(User user) throws UserRegistrationException {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserRegistrationException("Username already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserRegistrationException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Object findUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }
}
