package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Reservation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long reservationId;

    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    @Column(nullable = false)
    private Integer targetPrice;

    @Column(nullable = false)
    private Integer transactionCount;

    @Builder
    public Reservation(Long portfolioId, Integer targetPrice, Integer transactionCount) {
        this.portfolioId = portfolioId;
        this.targetPrice = targetPrice;
        this.transactionCount = transactionCount;
    }

    public void update() {
    }
}
