package com.example.demo.service;

import com.example.demo.domain.InfoStock;
import com.example.demo.repository.InfoStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class InfoStockService {

    private final InfoStockRepository infoStockRepository;

    public InfoStock getStockById(Long stockId) {
        return infoStockRepository.findById(stockId)
                .orElseThrow(() -> new NoSuchElementException("Stock not found"));
    }


}
