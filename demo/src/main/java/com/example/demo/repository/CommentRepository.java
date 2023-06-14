package com.example.demo.repository;

import com.example.demo.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository {
    Comment save(Comment comment);

    List<Comment> findByContentId(Long contentId);

    Optional<Comment> findByCommentId(Long commentId);

    void delete(Long commentId);
}
