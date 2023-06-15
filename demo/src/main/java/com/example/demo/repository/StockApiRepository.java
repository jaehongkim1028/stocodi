package com.example.demo.repository;


import com.example.demo.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockApiRepository extends JpaRepository<Stock, Long> {
    Stock findByStockName(String stockName);
}
