package com.example.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public EncryptionService() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean match(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }
}