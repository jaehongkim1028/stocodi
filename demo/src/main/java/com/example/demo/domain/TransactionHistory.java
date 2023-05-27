package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TransactionHistory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionHistoryId;

    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    @Column(name = "STOCK_ID")
    private Long stockId;

    @Column(nullable = false)
    private Integer transactionCount;

    @Column(nullable = false)
    private Integer executionPrice;

    @Column(nullable = false)
    private Boolean isBuy;

    @Builder
    public TransactionHistory(Long portfolioId, Long stockId, Integer transactionCount, Integer executionPrice, Boolean isBuy) {
        this.portfolioId = portfolioId;
        this.stockId = stockId;
        this.transactionCount = transactionCount;
        this.executionPrice = executionPrice;
        this.isBuy = isBuy;
    }

    public void update() {
    }

}
