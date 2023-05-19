package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Builder
public class Portfolio extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Column(name = "EMAIL")
    private String email;

    @Column(nullable = false)
    private Integer initialCash;

    @Column(nullable = false)
    private Integer currentCash;

    @Column(nullable = false)
    private Integer totalAsset;

    @Builder
    public Portfolio(Long portfolioId, String email, Integer initialCash, Integer currentCash, Integer totalAsset) {
        this.portfolioId = portfolioId;
        this.email = email;
        this.initialCash = initialCash;
        this.currentCash = currentCash;
        this.totalAsset = totalAsset;
    }

    public void update() {
    }
}
