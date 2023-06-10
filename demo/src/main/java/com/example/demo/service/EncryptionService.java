package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncryptionService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean match(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }
}