package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ScrapList extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrapId;

    @Column(name = "EMAIL", length = 500, nullable = false)
    private String email;

    @Column(name = "CONTENT_ID")
    private Long contentId;

    // Builder를 통한 초기화
    @Builder
    public ScrapList(Long scrapId, String email, Long contentId) {
        this.scrapId = scrapId;
        this.contentId = contentId;
        this.email = email;
    }
}
