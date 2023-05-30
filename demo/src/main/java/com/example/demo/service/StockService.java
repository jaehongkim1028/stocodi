package com.example.demo.service;

import com.example.demo.domain.Stock;
import com.example.demo.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    public Stock findByName(String stockName) {
        return stockRepository.findByName(stockName).get();
    }
}
