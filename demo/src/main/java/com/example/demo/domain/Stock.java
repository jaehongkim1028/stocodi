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

    // Builder를 통한 초기화
    @Builder
    public Stock(String stockName) {
        this.stockName = stockName;
    }

    public void update() {
    }
}