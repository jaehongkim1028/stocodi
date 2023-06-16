package com.example.demo.repository;

import com.example.demo.domain.HoldingStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldingStockRepository extends JpaRepository<HoldingStock, Long> {

}
