package com.example.demo.repository;

import com.example.demo.domain.Portfolio;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface PortfolioRepository {

    Portfolio save(Portfolio portfolio);

    Optional<Portfolio> findById(Long portfolioId);
    Optional<Portfolio> findByName(String portfolioName);

    Optional<Portfolio> findByInitialCash(Integer initialCash);
    Optional<Portfolio> findByCurrentCash(Integer currentCahs);
    List<Portfolio> findAll();


}


