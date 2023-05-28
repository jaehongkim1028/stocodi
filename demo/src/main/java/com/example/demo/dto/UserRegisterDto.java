package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {
    private String email;
    private String name;
    private String pwd;
    private Boolean isAdmin;
    private String age;
    private String phone;
}
