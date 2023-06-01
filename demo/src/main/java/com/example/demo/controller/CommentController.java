package com.example.demo.controller;

import com.example.demo.domain.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/comment/new")
    public String createForm(){
        return "comment/createCommentForm";
    }

    // 특정 게시물(contentId)에 댓글 생성
    @PostMapping("/comment/{contentId}/new")
    public String create(@PathVariable long contentId, CommentForm form){
        Comment comment = new Comment();
        comment.setComment(form.getComment());
        comment.setCommentId(form.getCommentId());
        comment.setEmail(form.getEmail());
        comment.setContentId(contentId);

        commentService.create(comment);

        return "comment/createCommentForm" + contentId;
    }

    @GetMapping("/comment/{contentId}")
    public String list(@PathVariable long contentId, Model model){
        List<Comment> comments = commentService.findComment(contentId);
        model.addAttribute("comments", comments);

        return "comments/commentList";
    }

    // 댓글 수정
    @GetMapping("/comments/update/{commentId}")
    public String updateForm(@PathVariable Long commentId, Model model){
        Comment comment = commentService.findOne(commentId).get();
        model.addAttribute("comment", comment);

        return "comment/updateComment";
    }

    @PostMapping("/comments/update/{commentId}")
    public String update(@PathVariable Long commentId, Comment newComment){
        commentService.update(commentId, newComment);

        return "redirect:/comment";
    }

    // 댓글 삭제
    @GetMapping("/comments/delete/{commentId}")
    public String delete(@PathVariable Long commentId){
        commentService.delete(commentId);

        return "redirect:/comment";
    }
}