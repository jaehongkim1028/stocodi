package com.example.demo.repository;

import com.example.demo.domain.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class JpaCommentRepository implements CommentRepository{

    private final EntityManager em;

    public JpaCommentRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Comment save(Comment comment){
        em.persist(comment);
        return comment;
    }

    @Override
    public List<Comment> findByContentId(Long contentId) {
        return em.createQuery("select a from Comment a" +
                "where a.contentId = :contentId", Comment.class)
                .getResultList();
    }

    @Override
    public void delete(Long commentId) {
        Comment comment = findByCommentId(commentId).orElseThrow(()
        ->new EntityNotFoundException("Comment NotFoung"));

        em.remove(comment);
    }
}
