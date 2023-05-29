//package com.example.demo.DTO;
//
//import com.example.demo.domain.Comment;
//import com.example.demo.DTO.UserRequest;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class CommentResponse {
//
//    private Long id;
//    private String content;
//    private UserRequest writer;
//    private List<CommentResponse> children = new ArrayList<>();
//
//    public CommentResponse(Long id, String content, UserRequest writer) {
//        this.id = id;
//        this.content = content;
//        this.writer = writer;
//    }
//
//    public static CommentResponse convertCommentToDto(Comment comment) {
//        return comment.getIsDeleted() ?
//                new CommentResponse(comment.getId(), "삭제된 댓글입니다.", null) :
//                new CommentResponse(comment.getId(), comment.getContent(), new UserRequest(comment.getWriter()));
//    }
//}
