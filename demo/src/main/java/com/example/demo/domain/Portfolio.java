package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Portfolio {

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

        // New, PortfolioName
        @Column(nullable = false)
        private String portfolioName;

        // New, HoldingStockList
        @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
        private List<HoldingStock> holdingStockList = new ArrayList<>();


        @Builder
        public Portfolio(Integer initialCash, String portfolioName, Integer currentCash, String email, Integer totalAsset) {
                this.initialCash = initialCash;
                this.portfolioName = portfolioName;
                this.currentCash = currentCash;
                this.totalAsset = totalAsset;
                this.email = email;
        }

}
