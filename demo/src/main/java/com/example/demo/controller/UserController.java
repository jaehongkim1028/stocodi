package com.example.demo.controller;

import com.example.demo.dto.StringResponseDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.exception.UserRegistrationException;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/api/users/register")
    public ResponseEntity<StringResponseDto> registerUser(HttpServletResponse response, @Valid @RequestBody UserRegisterDto userDto) {
        userService.register(userDto);
        return ResponseEntity.ok(new StringResponseDto("Registration successful"));
    }

    @PostMapping("/api/users/login")
    public ResponseEntity<StringResponseDto> loginUser(HttpServletResponse response, @Valid @RequestBody UserLoginDto loginDto) {
        String token = userService.login(loginDto);

        if (token != null) {
            Cookie tokenCookie = new Cookie("token", token);
            tokenCookie.setMaxAge(3600);
            response.addCookie(tokenCookie);
            return ResponseEntity.ok(new StringResponseDto("Login successful"));
        } else {
            return ResponseEntity.status(401).body(new StringResponseDto("Login failed"));
        }
    }

    @GetMapping("/api/users/me")
    public ResponseEntity<StringResponseDto> currentUser(@CookieValue("token") String token){
        //get User's name by JWT token
        String currentUserName =  userService.getEmailFromToken(token);

        return ResponseEntity.ok(new StringResponseDto(currentUserName));
    }

    // ======================================= Exception handling ==============================================
    @ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity<StringResponseDto> handleUserRegistrationException(UserRegistrationException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(new StringResponseDto(errorMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StringResponseDto> handleException(Exception ex) {
        String errorMessage = "Internal Server Error. An error occurred.";
        return new ResponseEntity<>(new StringResponseDto(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
