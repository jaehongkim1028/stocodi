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

    public User register(UserRegisterDto userDto) {
        User user = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .pwd(userDto.getPwd()) // Remember to hash the password before storing it
                .isAdmin(userDto.getIsAdmin())
                .age(userDto.getAge())
                .phone(userDto.getPhone())
                .build();
        return userRepository.save(user);
    }

    public User login(UserLoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null && user.getPwd().equals(loginDto.getPwd())) { // Check the password correctly (hash comparison)
            return user;
        }
        return null;
    }
}
