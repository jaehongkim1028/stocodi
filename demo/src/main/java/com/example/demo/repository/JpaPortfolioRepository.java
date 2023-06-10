package com.example.demo.repository;

import com.example.demo.domain.HoldingStock;
import com.example.demo.domain.Portfolio;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    public void delete(Long id) {
        Portfolio portfolio = findById(id).orElseThrow(() -> new EntityNotFoundException("Article not found"));
        //optional null , throw
        em.remove(portfolio);
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

    @Override
    public Portfolio findByPortfolioName(String portfolioName) {
        String query = "SELECT p FROM Portfolio p WHERE p.portfolioName = :portfolioName";
        TypedQuery<Portfolio> typedQuery = em.createQuery(query, Portfolio.class);
        typedQuery.setParameter("portfolioName", portfolioName);

        return typedQuery.getSingleResult();
    }

    @PersistenceContext
    public List<HoldingStock> findHoldingStocks(Portfolio portfolio) {
        String query = "SELECT h FROM HoldingStock h WHERE h.portfolio = :portfolio";
        TypedQuery<HoldingStock> typedQuery = em.createQuery(query, HoldingStock.class);
        typedQuery.setParameter("portfolio", portfolio);

        return typedQuery.getResultList();
    }


}
