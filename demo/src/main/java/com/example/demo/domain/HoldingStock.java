package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Setter
public class HoldingStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long holdingStockId;

    @Column(name = "STOCK_ID")
    private Long stockId;

    // Change Type, Add Connection
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PORTFOLIO_ID")
    private Portfolio portfolio;

    @Column(nullable = false)
    private Integer averagePrice;

    // Edit
    @Column(nullable = false)
    private Integer holdingCount;

    @Column(nullable = false)
    private Integer totalPrice;

    // Entity Conncetion Method
    // HoldingStock <-> Portfolio
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
        portfolio.getHoldingStockList().add(this);
    }


    // Builder를 통한 초기화
    @Builder
    public HoldingStock(Long stockId, Portfolio portfolio, Integer averagePrice, Integer holdingCount, Integer totalPrice) {
        this.stockId = stockId;
        this.portfolio = portfolio;
        this.averagePrice = averagePrice;
        this.holdingCount = holdingCount;
        this.totalPrice = totalPrice;
    }

    // Bussiness Logic
    public void addStockCount(int count) {
        this.holdingCount += count;
    }

    public void subStockCount(int count) {
        int restCount = this.holdingCount - count;

        this.holdingCount = restCount;
    }

    public void update() {
    }
}