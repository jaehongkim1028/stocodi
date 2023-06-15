package com.example.demo.repository;

import com.example.demo.domain.LikeNumber;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaLikeNumberRepository implements LikeNumberRepository{

    private final EntityManager em;

    public JpaLikeNumberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public LikeNumber save(LikeNumber likeNumber){
        em.persist(likeNumber);
        return likeNumber;
    }

    @Override
    public Optional<LikeNumber> findByEmail(String email) {
        List<LikeNumber> result = em.createQuery("select a from LikeNumber" +
                        "where a.email = :email")
                .setParameter("email", email)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<LikeNumber> findByContentId(Long ContentId) {
        List<LikeNumber> result = em.createQuery("select a from LikeNumber" +
                "where a.ContentId = :ContentId")
                .setParameter("ContentId", ContentId)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<LikeNumber> findByEmailAndContentId(String email, Long ContentId) {
        List<LikeNumber> result = em.createQuery("select a from LikeNumber" +
                        "where a.email = :email" +
                        "and a.ContentId = :ContentId")
                .setParameter("email", email)
                .setParameter("ContentId", ContentId)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public void delete(String email, Long ContentId){
        LikeNumber likeNumber = findByEmailAndContentId(email, ContentId).orElseThrow(()
                -> new EntityNotFoundException("Error"));
    }
}
