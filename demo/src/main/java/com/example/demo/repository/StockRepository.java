package com.example.demo.repository;

import com.example.demo.domain.Stock;

import java.util.Optional;

public interface StockRepository {
    Optional<Stock> findByName(String stockName);

}
