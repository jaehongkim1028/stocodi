package com.example.demo.controller;


import com.example.demo.dto.HoldingStockDto;
import com.example.demo.dto.PortfolioDto;
import com.example.demo.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("api/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    // Create
    @PostMapping("/new")
    public PortfolioDto createPortfolio(@RequestBody PortfolioDto portfolioDto) {
        PortfolioDto createdPortfolioDto = portfolioService.createPortfolio(portfolioDto);
        return createdPortfolioDto;
    }

    // PortfolioName List 조회
    @GetMapping("/items")
    public List<String> list() {
        return portfolioService.findPortfolioNames();
    }

    // Read Portfolio information
    @GetMapping("/{portfolioId}")
    public ResponseEntity<PortfolioDto> getPortfolio(@PathVariable Long portfolioId) {
        try {
            PortfolioDto portfolioDto = portfolioService.getPortfolio(portfolioId);
            if (portfolioDto != null) {
                return ResponseEntity.ok(portfolioDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete
    @DeleteMapping("/delete/{portfolioId}")
    public void deletePortfolio(@PathVariable Long portfolioId) {
        portfolioService.deletePortfolio(portfolioId);
    }

    // HoldingList 조회
    @GetMapping("/{portfolioId}/holdingStocks")
    public ResponseEntity<List<HoldingStockDto>> getHoldingStockList(@PathVariable Long portfolioId) {
        try {
            List<HoldingStockDto> holdingStockDTOList = portfolioService.findHoldingStockList(portfolioId);
            return ResponseEntity.ok(holdingStockDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
