package com.example.demo.service;


import com.example.demo.domain.HoldingStock;
import com.example.demo.domain.Portfolio;
import com.example.demo.dto.HoldingStockDto;
import com.example.demo.repository.HoldingStockRepository;
import com.example.demo.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HoldingStockService {

    private final HoldingStockRepository holdingStockRepository;
    private final PortfolioRepository portfolioRepository;


    // Check already same HoldingStock
    public HoldingStockDto createHoldingStock(HoldingStockDto holdingStockDto) {

        // Retrieve the portfolio using portfolioId
        Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(holdingStockDto.getPortfolioId());
        if (optionalPortfolio.isEmpty()) {
            // Handle portfolio not found error
            // throw new PortfolioNotFoundException("Portfolio not found with ID: " + holdingStockDto.getPortfolioId());
        }

        Portfolio portfolio = optionalPortfolio.get();

        // Check if a HoldingStock with the same stockId already exists in the portfolio
        Optional<HoldingStock> optionalExistingHoldingStock = portfolio.getHoldingStockList()
                .stream()
                .filter(h -> h.getStockId().equals(holdingStockDto.getStockId()))
                .findFirst();

        if (optionalExistingHoldingStock.isPresent()) {
            // If an existing HoldingStock is found, update the average price, total price, and count
            HoldingStock existingHoldingStock = optionalExistingHoldingStock.get();
            int existingCount = existingHoldingStock.getHoldingCount();
            int existingTotalPrice = existingHoldingStock.getTotalPrice();
            int existingAveragePrice = existingHoldingStock.getAveragePrice();

            int newCount = existingCount + holdingStockDto.getHoldingCount();
            int newTotalPrice = existingTotalPrice + holdingStockDto.getTotalPrice();
            int newAveragePrice = newTotalPrice / newCount;

            existingHoldingStock.setHoldingCount(newCount);
            existingHoldingStock.setTotalPrice(newTotalPrice);
            existingHoldingStock.setAveragePrice(newAveragePrice);

            holdingStockRepository.save(existingHoldingStock);
            return HoldingStockDto.fromEntity(existingHoldingStock);
        }
        else {
            // Create HoldingStock entity
            HoldingStock holdingStock = HoldingStock.builder()
                    .stockId(holdingStockDto.getStockId())
                    .portfolio(portfolio)
                    .averagePrice(holdingStockDto.getAveragePrice())
                    .holdingCount(holdingStockDto.getHoldingCount())
                    .totalPrice(holdingStockDto.getTotalPrice())
                    .build();

            // Add HoldingStock to the portfolio
            portfolio.getHoldingStockList().add(holdingStock);

            // Save the HoldingStock
            holdingStockRepository.save(holdingStock);
            return HoldingStockDto.fromEntity(holdingStock);
        }
    }

    // find all HoldingStock
    public List<HoldingStock> findholdingStocks(){

        return holdingStockRepository.findAll();
    }

}
