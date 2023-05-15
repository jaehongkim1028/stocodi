package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Content extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTENT_ID")
    private Long contentId;

    @Column(name = "EMAIL", length = 500, nullable = false)
    private String email;

    @Column(length = 32, nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer likeCount;

    @Column(nullable = false)
    private Integer scrapCount;

    @Column(length = 500, nullable = false)
    private String storePlace;

    // Builder를 통한 초기화
    @Builder
    public Content(Long contentId, String email, String title, Integer likeCount, Integer scrapCount, String storePlace) {
        this.contentId = contentId;
        this.email = email;
        this.title = title;
        this.likeCount = likeCount;
        this.scrapCount = scrapCount;
        this.storePlace = storePlace;
    }

    // update를 통한 수정
    public void update() {
    }

}
