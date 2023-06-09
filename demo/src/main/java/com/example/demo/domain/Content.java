package com.example.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;
    private String email;
    private String title;
    private Integer likeCount;
    private String youtubeId;
    private String thumbnailUrl;
    private String writer;
    private String content;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Integer> hashtags = new ArrayList<Integer>();

public Content(Long contentId, String email, String title, Integer likeCount, String thumbnailUrl,
               String videoLink, String writer, String content, List<Integer> hashtags) {
    this.contentId = contentId;
    this.email = email;
    this.title = title;
    this.likeCount = likeCount;
    this.youtubeId = videoLink;
    this.writer = writer;
    this.content = content;
    this.hashtags = hashtags;
    this.thumbnailUrl = thumbnailUrl;
}

    public Content() { }

    public Long getContentId() {
        return contentId;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String videoLink) {
        this.youtubeId = videoLink;
    }

    public String getWriter() {
        return writer;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public List<Integer> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Integer> hashtags) {
        this.hashtags = hashtags;
    }

    public void setContentID(Long contentID) {
        this.contentId = contentId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}