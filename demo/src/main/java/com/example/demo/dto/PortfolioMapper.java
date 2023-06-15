package com.example.demo.dto;

public class PortfolioMapper {
    public static PortfolioDto mapToDto(Portfolio portfolio) {
        PortfolioDto portfolioDto = new PortfolioDto();
        portfolioDto.setInitialCash(portfolio.getInitialCash());
        portfolioDto.setPortfolioName(portfolio.getPortfolioName());
        portfolioDto.setCurrentCash(portfolio.getCurrentCash());
        portfolioDto.setEmail(portfolio.getEmail());
        portfolioDto.setTotalAsset(portfolio.getTotalAsset());

        return portfolioDto;
    }
}
