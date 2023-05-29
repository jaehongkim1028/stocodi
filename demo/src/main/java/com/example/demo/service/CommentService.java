package com.example.demo.service;

import com.example.demo.domain.Content;
import com.example.demo.repository.BoardRepository;
import com.example.demo.DTO.CommentRequest;
import com.example.demo.domain.Comment;
import com.example.demo.mapper.CommentRequestMapper;
import com.example.demo.repository.CommentRepository;
import com.example.demo.exception.NotFoundException;
import com.example.chuchu.member.entity.Member;
import com.example.chuchu.member.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ContentRepository contentRepository;
    private final CommentRequestMapper commentRequestMapper;

    @Transactional
    public Comment insert(Long ContentId, CommentRequest commentRequest) {

        User user = memberRepository.findById(commentRequest.getUserId())
                .orElseThrow(() -> new NotFoundException("Could not found member id : " + commentRequest.getUserId()));

        Content content = contentRepository.findById(contentId)
                .orElseThrow(() -> new NotFoundException("Could not found content id : " + contentId));

        Comment comment = commentRequestMapper.toEntity(commentRequest);

        Comment parentComment;
        if (commentRequest.getParentId() != null) {
            parentComment = commentRepository.findById(commentRequest.getParentId())
                    .orElseThrow(() -> new NotFoundException("Could not found comment id : " + commentRequest.getParentId()));
            comment.updateParent(parentComment);
        }

        comment.updateWriter(user);
        comment.updateBoard(content);

        return commentRepository.save(comment);

    }

    @Transactional
    public void delete(Long commentId) {
        Comment comment = commentRepository.findCommentByIdWithParent(commentId)
                .orElseThrow(() -> new NotFoundException("Could not found comment id : " + commentId));
        if(comment.getChildren().size() != 0) { // 자식이 있으면 상태만 변경
            comment.changeIsDeleted(true);
        } else { // 삭제 가능한 조상 댓글을 구해서 삭제
            commentRepository.delete(getDeletableAncestorComment(comment));
        }
    }

    private Comment getDeletableAncestorComment(Comment comment) {
        Comment parent = comment.getParent(); // 현재 댓글의 부모를 구함
        if(parent != null && parent.getChildren().size() == 1 && parent.getIsDeleted())
            // 부모가 있고, 부모의 자식이 1개(지금 삭제하는 댓글)이고, 부모의 삭제 상태가 TRUE인 댓글이라면 재귀
            return getDeletableAncestorComment(parent);
        return comment; // 삭제해야하는 댓글 반환
    }

    @Transactional
    public void update(Long commentId, CommentRequest commentRequest) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Could not found comment id : " + commentId));
        //TODO 해당 메서드를 호출하는 사옹자와 댓글을 작성한 작성자가 같은지 확인하는 로직이 필요함
        comment.updateContent(commentRequest.getContent());
    }
}
