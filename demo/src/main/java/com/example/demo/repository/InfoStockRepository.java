package com.example.demo.repository;

import com.example.demo.domain.InfoStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoStockRepository extends JpaRepository<InfoStock, Long> {
}