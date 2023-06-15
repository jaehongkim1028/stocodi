package com.example.demo.repository;

import com.example.demo.domain.InfoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoStockRepository extends JpaRepository<InfoStock, Long> {
    Optional<InfoStock> findByStockName(String stockName);
}