package com.example.demo.controller;

import com.example.demo.domain.InfoStock;
import com.example.demo.service.InfoStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class InfoStockController {

    private final InfoStockService stockService;

    // 조회
    @GetMapping(value = "/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InfoStock> getStockById(@PathVariable Long stockId) {
        InfoStock infoStock = stockService.getStockById(stockId);
        return ResponseEntity.ok(infoStock);
    }




}
