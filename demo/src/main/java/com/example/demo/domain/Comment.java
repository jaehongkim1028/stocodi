package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CONTENT_ID")
    private Long contentId;

    @Column(length = 500, nullable = false)
    private String commentContent;

    // Builder를 통한 초기화
    @Builder
    public Comment(String email, Long contentId, String commentContent) {
        this.email = email;
        this.contentId = contentId;
        this.commentContent = commentContent;
    }
}