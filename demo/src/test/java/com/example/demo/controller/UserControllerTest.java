package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.StringResponseDto;
import com.example.demo.dto.UserLoginDto;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest
@MockBean(JpaMetamodelMappingContext.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private User user;

    public UserControllerTest() {
        user = User.builder()
                .email("test2@example.com")
                .birth("20010927")
                .phone("01012345678")
                .name("test")
                .nickname("testnick")
                .pwd("password")
                .interest(List.of(1, 2, 3))
                .build();
    }

    @Test
    public void registerUser() throws Exception {
        // Given
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setEmail(user.getEmail());
        userRegisterDto.setBirth(user.getBirth());
        userRegisterDto.setPhone(user.getPhone());
        userRegisterDto.setName(user.getName());
        userRegisterDto.setNickname(user.getNickname());
        userRegisterDto.setPwd(user.getPwd());
        userRegisterDto.setInterest(user.getInterest());

        given(userService.register(any(UserRegisterDto.class)))
                .willReturn(true);

        // When
        ResultActions result = mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userRegisterDto)));
        // Then
        result.andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void loginUser() throws Exception {
        // Given
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setEmail(user.getEmail());
        userLoginDto.setPwd(user.getPwd());

        given(userService.login(any(UserLoginDto.class)))
                .willReturn("token");

        // When
        ResultActions result = mockMvc.perform(post("/api/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userLoginDto)));
        // Then
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(cookie().exists("token"))
                .andExpect(jsonPath("$.message", is("Login successful")));
    }
}