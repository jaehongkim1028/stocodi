package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;

    public User register(UserRegisterDto userDto) {
        String encodedPassword = encryptionService.encode(userDto.getPwd());

        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .pwd(encodedPassword) // Password is now hashed
                .isAdmin(userDto.getIsAdmin())
                .age(userDto.getAge())
                .phone(userDto.getPhone())
                .build();

        return userRepository.save(user);
    }

    public User login(UserLoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());

        if (user != null && encryptionService.match(loginDto.getPwd(), user.getPwd())) {
            return user;
        }
        return null;
    }
}
