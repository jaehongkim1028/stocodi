package com.example.demo.controller;

public class ContentForm {
    private Long contentID;
    private String email;
    private String title;
    private Integer likeCount;
    private Integer scrapCount;
    private String storePlace;

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

    public Integer getScrapCount() {
        return scrapCount;
    }

    public void setScrapCount(Integer scrapCount) {
        this.scrapCount = scrapCount;
    }

    public String getStorePlace() {
        return storePlace;
    }

    public void setStorePlace(String storePlace) {
        this.storePlace = storePlace;
    }
}
