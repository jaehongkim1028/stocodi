package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class UserRegisterDto {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    @NotEmpty
    @Size(min = 8)
    private String pwd;

    @NotEmpty
    private String age;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String nickname;

    @NotEmpty
    private List<Integer> interest;
}
