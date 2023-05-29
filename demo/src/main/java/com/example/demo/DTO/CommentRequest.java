package com.example.demo.DTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentRequest {
    private Long userId;
    private Long parentId;
    private String content;

    public CommentRequest(String content) {
        this.content = content;
    }
}