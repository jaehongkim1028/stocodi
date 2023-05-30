package com.example.demo.service;

import com.example.demo.domain.Portfolio;
import com.example.demo.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    // Portfolio 생성(Create)
    public String create(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
        return portfolio.getPortfolioName();
    }

    // 전체 Portfolio 가져오기
    public List<Portfolio> findPortfolios() {
        return portfolioRepository.findAll();
    }

    // Portfolio Update
    public Long update(Long id, Portfolio portfolio) {
        Portfolio originalPofol = portfolioRepository.findById(id).get(); // from optional
        originalPofol.setPortfolioName(portfolio.getPortfolioName());
        portfolioRepository.save(originalPofol);
        return portfolio.getPortfolioId();
    }

    // Delete
    public void delete(Long id) {
        portfolioRepository.delete(id);
    }

}
