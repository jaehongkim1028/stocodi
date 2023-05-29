package com.example.demo.repository;

import com.example.demo.domain.Portfolio;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaPortfolioRepository implements PortfolioRepository{

    public JpaPortfolioRepository(EntityManager em) {
        this.em = em;
    }

    private final EntityManager em;

    @Override
    public Portfolio save(Portfolio portfolio) {
        em.persist(portfolio);
        return portfolio;
    }

    @Override
    public Optional<Portfolio> findById(Long portfolioId) {
        Portfolio portfolio = em.find(Portfolio.class, portfolioId);
        return Optional.ofNullable(portfolio); // null 가능
    }
    @Override
    public Optional<Portfolio> findByName(String portfolioName) {
        Portfolio portfolio = em.find(Portfolio.class, portfolioName);
        return Optional.ofNullable(portfolio); // null 가능
    }


    @Override
    public Optional<Portfolio> findByInitialCash(Integer initialCash) {
        return Optional.empty();
    }

    @Override
    public Optional<Portfolio> findByCurrentCash(Integer currentCahs) {
        return Optional.empty();
    }

    @Override
    public List<Portfolio> findAll() {
            List<Portfolio> result = em.createQuery("select a from Portfolio a", Portfolio.class)
                    .getResultList();
            return result;

    }
}
