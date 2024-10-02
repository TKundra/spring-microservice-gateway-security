package com.learning.security_service.service;

import com.learning.security_service.entity.UserCredential;
import com.learning.security_service.jwt.JWTUtils;
import com.learning.security_service.repository.UserCredentialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {
    @Autowired
    private UserCredentialRepository userCredentialRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTUtils jwtUtils;

    public String saveUser(UserCredential userCredential) {
        // encode the password
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));

        // save the user
        userCredentialRepository.save(userCredential);

        // logging
        String msg = "User added to the system";
        log.info(msg);
        return msg;
    }

    public String generateToken(String username) {
        return jwtUtils.generateToken(username);
    }

    public boolean validateToken(String token) {
        return jwtUtils.validateToken(token);
    }
}
