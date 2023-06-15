package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class HoldingStockDto {
    private Long holdingStockId;
    private Long stockId;
    private Long portfolioId;
    private Integer averagePrice;
    private Integer holdingCount;
    private Integer totalPrice;

    // Constructors
    @Builder
    public HoldingStockDto(Long holdingStockId, Long stockId, Long portfolioId, Integer averagePrice, Integer holdingCount, Integer totalPrice) {
        this.holdingStockId = holdingStockId;
        this.stockId = stockId;
        this.portfolioId = portfolioId;
        this.averagePrice = averagePrice;
        this.holdingCount = holdingCount;
        this.totalPrice = totalPrice;
    }

    // fromEntity() method
    public static HoldingStockDto fromEntity(HoldingStock holdingStock) {
        HoldingStockDto holdingStockDto = new HoldingStockDto(
                holdingStock.getHoldingStockId(),
                holdingStock.getStockId(),
                holdingStock.getPortfolio().getPortfolioId(),
                holdingStock.getAveragePrice(),
                holdingStock.getHoldingCount(),
                holdingStock.getTotalPrice()
        );
        return holdingStockDto;
    }
}



