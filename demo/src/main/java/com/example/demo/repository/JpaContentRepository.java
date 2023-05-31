package com.example.demo.repository;

import com.example.demo.domain.Content;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaContentRepository implements ContentRepository{
    private final EntityManager em;

    public JpaContentRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Content save(Content content){
        em.persist(content);

        return content;
    }

    @Override
    public Optional<Content> findById(Long contentId){
        Content content = em.find(Content.class, contentId);
        return Optional.ofNullable(content);
    }

    @Override
    public List<Content> findAll() {
        return em.createQuery("select a from Content a", Content.class)
                .getResultList();
    }

    @Override
    public void delete(Long contentId){
        Content content = findById(contentId).orElseThrow(()
                -> new EntityNotFoundException("Content not found"));
    }
}
