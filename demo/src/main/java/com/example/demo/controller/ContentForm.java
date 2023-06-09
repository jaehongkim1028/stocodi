package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

public class ContentForm {
    private Long contentID;
    private String email;
    private String title;
    private Integer likeCount;
    private String YoutubeId;
    private String thumbnailUrl;
    private String writer;
    private String content;
//    private Integer hashtag;
    private List<Integer> hashtags = new ArrayList<Integer>();
    //private Integer scrapCount;
    //private String storePlace;

    public Long getContentID() {
        return contentID;
    }

    public void setContentID(Long contentID) {
        this.contentID = contentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getYoutubeId() {
        return YoutubeId;
    }

    public void setYoutubeId(String YoutubeId) {
        this.YoutubeId = YoutubeId;
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

    public List<Integer> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Integer> hashtags) {
        this.hashtags = hashtags;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    //    public Integer getHashtag() {
//        return hashtag;
//    }
//
//    public void setHashtag(Integer hashtag) {
//        this.hashtag = hashtag;
//    }

    //    public Integer getScrapCount() {
//        return scrapCount;
//    }
//
//    public void setScrapCount(Integer scrapCount) {
//        this.scrapCount = scrapCount;
//    }
//
//    public String getStorePlace() {
//        return storePlace;
//    }
//
//    public void setStorePlace(String storePlace) {
//        this.storePlace = storePlace;
//    }
}
