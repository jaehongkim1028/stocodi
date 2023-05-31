package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table (name = "Content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;
    private String email;
    private String title;
    private Integer likeCount;
    private String videoLink;
    private String writer;
    private String content;
    private Integer hashtag;
    //private Integer scrapCount;
    //private String storePlace;

    //public Content(Long contentID, String email, String title, Integer likeCount, Integer scrapCount, String storePlace) {
    public Content(Long contentId, String email, String title, Integer likeCount,
                   String videoLink, String writer, String content, Integer hashtag) {
        this.contentId = contentId;
        this.email = email;
        this.title = title;
        this.likeCount = likeCount;
        this.videoLink = videoLink;
        this.writer = writer;
        this.content = content;
        this.hashtag = hashtag;
        //this.scrapCount = scrapCount;
        //this.storePlace = storePlace;
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

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getWriter() {
        return writer;
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

    public Integer getHashtag() {
        return hashtag;
    }

    public void setHashtag(Integer hashtag) {
        this.hashtag = hashtag;
    }

    //    public Integer getScrapCount() {
//        return scrapCount;
//    }
//
//    public String getStorePlace() {
//        return storePlace;
//    }

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

//    public void setScrapCount(Integer scrapCount) {
//        this.scrapCount = scrapCount;
//    }
//
//    public void setStorePlace(String storePlace) {
//        this.storePlace = storePlace;
//    }
}