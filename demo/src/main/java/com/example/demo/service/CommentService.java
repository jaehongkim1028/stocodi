package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Content;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    // 댓글 생성
    public Long create(Comment comment){
        commentRepository.save(comment);

        return comment.getCommentId();
    }

    //댓글 조회
    public List<Comment> findComment(Long contentId) {
        return commentRepository.findByContentId(contentId);
    }

    public Optional<Comment> findOne(Long commentId){
        return commentRepository.findByCommentId(commentId);
    }

    public Long update(Long commentId, Comment comment){
        Comment originalComment = commentRepository.findByCommentId(commentId).get();
        originalComment.setComment(comment.getComment());

        return comment.getCommentId();
    }

    public void delete(Long commentId){
        commentRepository.delete(commentId);
    }
}
