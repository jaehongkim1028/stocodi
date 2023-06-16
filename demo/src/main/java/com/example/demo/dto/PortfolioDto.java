package com.example.demo.dto;

import com.example.demo.domain.Portfolio;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioDto {
    private Integer initialCash;
    private String portfolioName;
    private Integer currentCash;
    private String email;
    private Integer totalAsset;

    // Add any additional methods or constructors as needed
    // static method to convert from entity to DTO
    public static PortfolioDto fromEntity(Portfolio portfolio) {
        return new PortfolioDto(
                portfolio.getInitialCash(),
                portfolio.getPortfolioName(),
                portfolio.getCurrentCash(),
                portfolio.getEmail(),
                portfolio.getTotalAsset()
        );
    }

}