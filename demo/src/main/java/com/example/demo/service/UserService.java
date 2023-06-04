package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.exception.UserRegistrationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private EncryptionService encryptionService;
    private JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, EncryptionService encryptionService, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
        this.jwtUtil = jwtUtil;
    }

    public void register(UserRegisterDto userDto) {
        String encodedPassword = encryptionService.encode(userDto.getPwd());

        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .pwd(encodedPassword) // Password is now hashed
                .birth(userDto.getBirth())
                .phone(userDto.getPhone())
                .nickname(userDto.getNickname())
                .interest(userDto.getInterest())
                .build();

        User existingUser = userRepository.findByEmail(userDto.getEmail());
        if (existingUser != null) {
            throw new UserRegistrationException("User with the provided email already exists.");
        }

        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new UserRegistrationException("Failed to register user : " + e);
        }
    }


    public String login(UserLoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());

        if (user != null && encryptionService.match(loginDto.getPwd(), user.getPwd())) {
            return jwtUtil.generateToken(user.getEmail());
        }
        return null;
    }

    // get name from string token using JwtUtil
    public String getEmailFromToken(String token) {
        return jwtUtil.extractSubject(token);
    }

    public List<Integer> getUserListByEmail(String email) {
        return userRepository.findByEmail(email).getInterest();
    }
}
