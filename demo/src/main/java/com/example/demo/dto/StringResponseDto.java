package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StringResponseDto {
    private String message;

    public StringResponseDto(String message) {
        this.message = message;
    }
}
