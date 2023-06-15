package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Stock extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID")
    private Long stockId;

    @Column(length = 100, nullable = false)
    private String stockName;

    // stockMaxPrice
    @Column(nullable = false)
    private String stockMaxPrice;

    // stockMinPrice
    @Column(nullable = false)
    private String stockMinPrice;

    // stockStartPrice
    @Column(nullable = false)
    private String stockStartPrice;

    // stockEndPrice
    @Column(nullable = false)
    private String stockEndPrice;

    // stockDate
    @Column(nullable = false)
    private String stockDate;

    // stockQuantity
    @Column(nullable = false)
    private String stockQuantity;

    // Builder를 통한 초기화
    @Builder
    public Stock(String stockName, String stockMaxPrice, String stockMinPrice, String stockStartPrice, String stockEndPrice, String stockDate, String stockQuantity) {
        this.stockName = stockName;
        this.stockMaxPrice = stockMaxPrice;
        this.stockMinPrice = stockMinPrice;
        this.stockStartPrice = stockStartPrice;
        this.stockEndPrice = stockEndPrice;
        this.stockDate = stockDate;
        this.stockQuantity = stockQuantity;
    }
    public void update() {
    }
}