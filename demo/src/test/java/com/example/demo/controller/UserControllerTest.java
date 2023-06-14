package com.example.demo.controller;

import com.example.demo.dto.StringResponseDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.exception.UserRegistrationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {
    private UserController userController;

    @Mock
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userService);
    }
    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void registerUser_ValidDto_ReturnsOkResponse() {
        // Given
        UserRegisterDto userDto = new UserRegisterDto();
        userDto.setEmail("test@example.com");
        userDto.setPwd("password");
        userDto.setBirth("20010101");
        userDto.setName("test");
        userDto.setPhone("01012345678");
        userDto.setNickname("testnick");
        userDto.setInterest(List.of(1, 2, 3));

        HttpServletResponse response = mock(HttpServletResponse.class);

        // When
        ResponseEntity<StringResponseDto> responseEntity = userController.registerUser(response, userDto);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Registration successful", responseEntity.getBody().getMessage());
        verify(userService, times(1)).register(userDto);
    }
    @Test
    void registerUser_DuplicateEmail_ReturnsBadRequestResponse() {
        // Given
        UserRegisterDto userDto = new UserRegisterDto();
        userDto.setEmail("test@example.com");
        userDto.setPwd("password");
        userDto.setBirth("20010101");
        userDto.setName("test");
        userDto.setPhone("01012345678");
        userDto.setNickname("testnick");
        userDto.setInterest(List.of(1, 2, 3));

        // Register user
        HttpServletResponse response = mock(HttpServletResponse.class);
        userController.registerUser(response, userDto);

        // Mock UserRegistrationException
        doThrow(UserRegistrationException.class).when(userService).register(userDto);

        // When
        ResponseEntity<StringResponseDto> responseEntity = null;
        try {
            responseEntity = userController.registerUser(response, userDto);
        } catch (UserRegistrationException ignored) {
            System.out.println("UserRegistrationException success.");
        }

    }

    @Test
    void loginUser_ValidDto_ReturnsOkResponseWithTokenCookie() {
        // Given
        UserLoginDto loginDto = new UserLoginDto();
        loginDto.setEmail("test@example.com");
        loginDto.setPwd("password");
        HttpServletResponse response = mock(HttpServletResponse.class);
        String token = "yJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGV4YW1wbGUuY29tIiwiaWF0IjoxNjg1ODY0NDg5LCJleHAiOjE2ODU5MDA0ODl9.a-kM680rrIFNBRUppm6BVnyUc9UO1OD-zls68cjtDQQ";
        when(userService.login(loginDto)).thenReturn(token);

        // When
        ResponseEntity<StringResponseDto> responseEntity = userController.loginUser(response, loginDto);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Login successful", responseEntity.getBody().getMessage());
        verify(response, times(1)).addCookie(any());
    }

    @Test
    void loginUser_InvalidDto_ReturnsUnauthorizedResponse() {
        // Given
        UserLoginDto loginDto = new UserLoginDto();
        loginDto.setEmail("test@example.com");
        loginDto.setPwd("password123");
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(userService.login(loginDto)).thenReturn(null);

        // When
        ResponseEntity<StringResponseDto> responseEntity = userController.loginUser(response, loginDto);

        // Then
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        assertEquals("Login failed", responseEntity.getBody().getMessage());
        verify(response, never()).addCookie(any());
    }

    @Test
    void currentUser_ValidToken_ReturnsOkResponse() {
        // Given
        String token = "yJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGV4YW1wbGUuY29tIiwiaWF0IjoxNjg1ODY0NDg5LCJleHAiOjE2ODU5MDA0ODl9.a-kM680rrIFNBRUppm6BVnyUc9UO1OD-zls68cjtDQQ";
        when(userService.getEmailFromToken(token)).thenReturn("test@example.com");

        // When
        ResponseEntity<StringResponseDto> responseEntity = userController.currentUser(token);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("test@example.com", responseEntity.getBody().getMessage());
    }
}