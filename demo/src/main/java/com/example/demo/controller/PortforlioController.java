package com.example.demo.controller;

import com.example.demo.domain.Portfolio;
import com.example.demo.sevice.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PortforlioController {

    private final PortfolioService portfolioService;

    @Autowired
    public PortforlioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }


    // 생성
    @GetMapping("/portfolios/new")
    public String createForm() {
        return "portfolios/createPortfolioForm";
    }

    @PostMapping("/portfolios/new")
    public String create(PortfolioForm form){
        Portfolio portfolio = new Portfolio();
        portfolio.setEmail(form.getPortfolioName());
        portfolio.setPortfolioName(form.getPortfolioName());
        portfolio.setInitialCash(form.getInitialPrice());
        portfolio.setCurrentCash(form.getInitialPrice());
        portfolio.setTotalAsset(form.getInitialPrice());

        portfolioService.create(portfolio);

        return "redirect:/";
    }

     // 조회
    @GetMapping("/portfolios/items")
    public String list(Model model) {
        List<Portfolio> portfolios = portfolioService.findPortfolios();
        model.addAttribute("portfolios",portfolios);
        return ("portfolios/portfolioList");
        //return "portfolios/createPortfolioForm";

    }

}
