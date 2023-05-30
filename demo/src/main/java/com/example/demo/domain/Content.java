package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table (name = "Content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentID;
    private String email;
    private String title;
    private Integer likeCount;
    private Integer scrapCount;
    private String storePlace;

    public Content(Long contentID, String email, String title, Integer likeCount, Integer scrapCount, String storePlace) {
        this.contentID = contentID;
        this.email = email;
        this.title = title;
        this.likeCount = likeCount;
        this.scrapCount = scrapCount;
        this.storePlace = storePlace;
    }

    public Content() { }

    public Long getContentId() {
        return contentID;
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

    public Integer getScrapCount() {
        return scrapCount;
    }

    public String getStorePlace() {
        return storePlace;
    }

    public void setContentID(Long contentID) {
        this.contentID = contentID;
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

    public void setScrapCount(Integer scrapCount) {
        this.scrapCount = scrapCount;
    }

    public void setStorePlace(String storePlace) {
        this.storePlace = storePlace;
    }
}