package com.example.demo.controller;

import com.example.demo.domain.HoldingStock;
import com.example.demo.service.HoldingStockService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HoldingStockController {

    private final HoldingStockService holdingStockService;


    //create new Stock or Add


    //read List



}
