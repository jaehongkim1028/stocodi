package main.java.com.example.demo.repository;

import com.example.demo.DTO.CommentResponse;
import com.example.demo.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentCustomRepository {

    List<CommentResponse> findByBoardId(Long id);
    Optional<Comment> findCommentByIdWithParent(Long id);
}
