package com.example.demo.repository;

import com.example.demo.domain.HoldingStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldingStockRepository extends JpaRepository<HoldingStock, Long> {

    HoldingStock findByPortfolioName(String portfolioName);
}
