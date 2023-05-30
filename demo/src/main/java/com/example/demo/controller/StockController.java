package com.example.demo.controller;

import com.example.demo.domain.Stock;
import com.example.demo.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/stock/{name}")
    public ResponseEntity<Stock> read(@PathVariable("name") String stockName) {
        //System.out.println(stockService.findByName(stockName));
        return ResponseEntity
                .ok(stockService.findByName(stockName));
    }
}
