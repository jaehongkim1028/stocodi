package com.example.demo.controller;

import com.example.demo.dto.StringResponseDto;
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
@MockBean(JpaMetamodelMappingContext.class)
class HealthCheckControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void healthCheck() throws Exception {
        // Given
        String healthCheck = "health check";

        // When
        ResultActions result = mockMvc.perform(get("/api/healthCheck"));

        // Then
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(healthCheck));
    }

    @Test
    public void healthCheckPost() throws Exception {
        // Given
        StringResponseDto stringResponseDto = new StringResponseDto("health check post");

        // When
        ResultActions result = mockMvc.perform(post("/api/healthCheck/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(stringResponseDto)));
        // Then
        result.andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$.message", is(stringResponseDto.getMessage())));

    }
}