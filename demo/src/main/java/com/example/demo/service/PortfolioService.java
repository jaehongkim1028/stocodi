package com.example.demo.service;

import com.example.demo.domain.HoldingStock;
import com.example.demo.domain.Portfolio;
import com.example.demo.dto.HoldingStockDto;
import com.example.demo.dto.PortfolioDto;
import com.example.demo.dto.PortfolioMapper;
import com.example.demo.repository.PortfolioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    // Portfolio 생성(Create)
    public PortfolioDto createPortfolio(PortfolioDto portfolioDto) {
        Portfolio portfolio = Portfolio.builder()
                .initialCash(portfolioDto.getInitialCash())
                .portfolioName(portfolioDto.getPortfolioName())
                .currentCash(portfolioDto.getCurrentCash())
                .email(portfolioDto.getEmail())
                .totalAsset(portfolioDto.getTotalAsset())
                .build();
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);
        return PortfolioDto.fromEntity(savedPortfolio);
    }

    // Read
    public List<Portfolio> findPortfolios() {
        return portfolioRepository.findAll();
    }

    public List<String> findPortfolioNames() {
        List<Portfolio> portfolios = portfolioRepository.findAll();

        return portfolios.stream()
                .map(Portfolio::getPortfolioName)
                .collect(Collectors.toList());
    }

    // Portfolio Update
    public Long update(Long id, Portfolio portfolio) {
        Portfolio originalPofol = portfolioRepository.findById(id).get(); // from optional
        originalPofol.setPortfolioName(portfolio.getPortfolioName());
        portfolioRepository.save(originalPofol);
        return portfolio.getPortfolioId();
    }

    // Delete
    public void deletePortfolio(Long portfolioId) {
        portfolioRepository.deleteById(portfolioId);
    }

    // find holdingStockList
    public List<HoldingStockDto> findHoldingStockList(Long portfolioId) throws JsonProcessingException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("포트폴리오를 찾을 수 없습니다."));

        List<HoldingStock> holdingStockList = portfolio.getHoldingStockList();
        List<HoldingStockDto> holdingStockDtoList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        for (HoldingStock holdingStock : holdingStockList) {
            HoldingStockDto holdingStockDto = HoldingStockDto.builder()
                    .holdingStockId(holdingStock.getHoldingStockId())
                    .stockId(holdingStock.getStockId())
                    .averagePrice(holdingStock.getAveragePrice())
                    .holdingCount(holdingStock.getHoldingCount())
                    .totalPrice(holdingStock.getTotalPrice())
                    .build();

            holdingStockDtoList.add(holdingStockDto);
        }

        return holdingStockDtoList;
    }

    // Get Portfolio by ID
    public PortfolioDto getPortfolio(Long portfolioId) {
        Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(portfolioId);
        if (optionalPortfolio.isPresent()) {
            Portfolio portfolio = optionalPortfolio.get();
            // Map Portfolio entity to PortfolioDto
            PortfolioDto portfolioDto = PortfolioMapper.mapToDto(portfolio);
            return portfolioDto;
        }
        return null;
    }
}

