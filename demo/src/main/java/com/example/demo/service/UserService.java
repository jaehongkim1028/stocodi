package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String register(UserRegisterDto userDto) {
        String encodedPassword = encryptionService.encode(userDto.getPwd());

        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .pwd(encodedPassword) // Password is now hashed
                .isAdmin(userDto.getIsAdmin())
                .age(userDto.getAge())
                .phone(userDto.getPhone())
                .build();

        userRepository.save(user);
        return jwtUtil.generateToken(userDto.getEmail());
    }

    public String login(UserLoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());

        if (user != null && encryptionService.match(loginDto.getPwd(), user.getPwd())) {
            return jwtUtil.generateToken(user.getEmail());
        }
        return null;
    }
}
