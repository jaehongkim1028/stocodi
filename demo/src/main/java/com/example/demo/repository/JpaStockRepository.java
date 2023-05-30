package com.example.demo.repository;

import com.example.demo.domain.Portfolio;
import com.example.demo.domain.Stock;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class JpaStockRepository implements StockRepository{

    private final EntityManager em;

    public JpaStockRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<Stock> findByName(String stockName) {
        Stock stock = em.find(Stock.class, stockName);
        return Optional.ofNullable(stock); // null 가능
    }
}
