package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserLoginDto {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String pwd;
}
