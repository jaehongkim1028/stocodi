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

    public InfoStock getStockByStockName(String stockName) {
        InfoStock infostock =  infoStockRepository.findByStockName(stockName)
                .orElseThrow(() -> new NoSuchElementException("Stock not found"));
        return infostock;
    }


}
