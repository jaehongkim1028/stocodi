package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class InterestedItem extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestedItemId;

    @Column(name = "STOCK_ID")
    private String stockId;

    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    // Builder를 통한 초기화
    @Builder
    public InterestedItem(String stockId, Long portfolioId) {
        this.stockId = stockId;
        this.portfolioId = portfolioId;
    }

    public void update() {
    }
}