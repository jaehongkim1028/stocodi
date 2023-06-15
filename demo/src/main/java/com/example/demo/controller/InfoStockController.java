package com.example.demo.controller;

import com.example.demo.domain.InfoStock;
import com.example.demo.service.InfoStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/stockInfo")
@RequiredArgsConstructor
public class InfoStockController {

    private final InfoStockService stockService;

    // 조회
    @GetMapping(value = "/{stockName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InfoStock> getStockByStockName(@PathVariable String stockName){
        InfoStock infoStock = stockService.getStockByStockName(stockName);
        return ResponseEntity.ok(infoStock);
    }




}
