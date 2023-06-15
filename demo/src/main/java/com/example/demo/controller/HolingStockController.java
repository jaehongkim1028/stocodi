package com.example.demo.controller;

import com.example.demo.domain.HoldingStock;
import com.example.demo.dto.HoldingStockDto;
import com.example.demo.service.HoldingStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
@RequiredArgsConstructor
public class HolingStockController {

    private final HoldingStockService holdingStockService;

    @GetMapping(value = "/holdingstocks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HoldingStock>> getList() {
        List<HoldingStock> holdingStocks = holdingStockService.findholdingStocks();
        return ResponseEntity.ok(holdingStocks);
    }

    @PostMapping(value = "/holdingstock/create")
    public HoldingStockDto createHoldingStock(@RequestBody HoldingStockDto holdingStockDto) {
        return holdingStockService.createHoldingStock(holdingStockDto);
    }


}
