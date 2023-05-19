package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class HoldingStock extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long holdingStockId;

    @Column(name = "STOCK_ID")
    private String stockId;

    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    @Column(nullable = false)
    private Integer averagePrice;

    @Column(nullable = false)
    private Integer holdingAccount;
    @Column(nullable = false)
    private Integer totalPrice;

    // Builder를 통한 초기화
    @Builder
    public HoldingStock(String stockId, Long portfolioId, Integer averagePrice, Integer holdingAccount, Integer totalPrice) {
        this.stockId = stockId;
        this.portfolioId = portfolioId;
        this.averagePrice = averagePrice;
        this.holdingAccount = holdingAccount;
        this.totalPrice = totalPrice;
    }

    public void update() {
    }
}