package com.example.demo.repository;

import com.example.demo.domain.Content;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaContentRepository implements ContentRepository {
    private final EntityManager em;
    public JpaContentRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public Content save(Content content) {
        em.persist(content);
        return content;
    }

    @Override
    public Optional<Content> findById(Long id) {
        Content content = em.find(Content.class, id);
        return Optional.ofNullable(content);
    }

    @Override
    public Optional<Content> findByTitle(String title) {
        List<Content> result = em.createQuery("select c from Content c where c.title = :title", Content.class)
                .setParameter("title", title)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Content> findAll() {
        List<Content> result = em.createQuery("select c from Content c", Content.class)
                .getResultList();
        return result;
    }
}
