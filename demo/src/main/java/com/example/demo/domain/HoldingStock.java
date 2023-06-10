package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class HoldingStock extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long holdingStockId;

    @Column(name = "STOCK_ID")
    private Long stockId;

    // id 에서 name으로 변경
    @Column(name = "PORTFOLIO_NAME")
    private String portfolioName;
    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    @Column(nullable = false)
    private Integer averagePrice;

    @Column(nullable = false)
    private Integer holdingAccount;

    @Column(nullable = false)
    private Integer totalPrice;

    // Portfolio와 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    // Builder를 통한 초기화
    @Builder
    public HoldingStock(Long stockId, Long portfolioId, Integer averagePrice, Integer holdingAccount, Integer totalPrice) {
        this.stockId = stockId;
        this.portfolioId = portfolioId;
        this.averagePrice = averagePrice;
        this.holdingAccount = holdingAccount;
        this.totalPrice = totalPrice;
    }

    public void update() {
    }
}