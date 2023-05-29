package com.example.demo.controller;

import com.example.demo.dto.CommentRequest;
import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import com.example.demo.domain.HttpResponseEntity.ResponseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.domain.HttpResponseEntity.success;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("demo")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{boardId}")
    public ResponseResult<Comment> insert(@PathVariable Long contentId,
                                          @RequestBody CommentRequest commentRequest) {

        // TODO 뭘 return 하는게 좋을지 고민해보자
        commentService.insert(contentId, commentRequest);
        return success();
    }

    @PutMapping("/{commentId}")
    public ResponseResult<Comment> update(@PathVariable Long commentId, @RequestBody CommentRequestDTO commentRequest) {
        commentService.update(commentId, commentRequest);
        // TODO 뭘 return 하는게 좋을지 고민해보자
        return success();
    }

    @DeleteMapping("/{commentId}
    //TODO return Type 명시하기
    public ResponseResult<Comment> delete(@PathVariable Long commentId) {
        commentService.delete(commentId);
        // TODO 뭘 return 하는게 좋을지 고민해보자
        return success();
    }

}
