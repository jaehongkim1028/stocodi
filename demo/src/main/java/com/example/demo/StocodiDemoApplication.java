package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StocodiDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(StocodiDemoApplication.class, args);
	}

}
