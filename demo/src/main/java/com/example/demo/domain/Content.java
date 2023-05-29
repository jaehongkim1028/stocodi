package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

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

    @ElementCollection
    @CollectionTable(name = "HashTags", joinColumns = @JoinColumn(name = "CONTENT_ID"))
    @Column(name = "hashtag")
    private Set<Integer> hashtags = new HashSet<>();

    @Column(name = "videoID")
    private String videoID;

    @Column(name = "writer")
    private String writer;

    @Column(length = 32, nullable = false)
    private String title;

    @Column(length = 128, nullable = false)
    private String detail;

    @Column(nullable = false)
    private Integer likeCount;

    @Column(nullable = false)
    private Integer scrapCount;

    @Column(length = 500, nullable = false)
    private String storePlace;

    // Builder를 통한 초기화
    @Builder
    public Content(String email, Set<Integer> hashtags, String videoID, String writer, String title, String detail, Integer likeCount, Integer scrapCount, String storePlace) {
        this.email = email;
        this.hashtags = hashtags;
        this.videoID = videoID;
        this.writer = writer;
        this.detail = detail;
        this.title = title;
        this.likeCount = likeCount;
        this.scrapCount = scrapCount;
        this.storePlace = storePlace;
    }


}