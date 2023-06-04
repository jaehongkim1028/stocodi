package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@RequiredArgsConstructor
public class UserLoginDto {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String pwd;
}
