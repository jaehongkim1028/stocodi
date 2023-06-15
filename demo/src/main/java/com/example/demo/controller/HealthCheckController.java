package com.example.demo.controller;

import com.example.demo.dto.StringResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HealthCheckController {
    // health check
     @GetMapping("/api/healthCheck")
     public String health() {
         return "health check";
     }

    @PostMapping("/api/healthCheck/post")
    public ResponseEntity<StringResponseDto> healthPost(@RequestBody StringResponseDto stringResponseDto) {
        return ResponseEntity.ok(stringResponseDto);
    }
}
