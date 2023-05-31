package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class LikeNumber {
    @Id
    @Column(name = "LIKENUMBER_ID")
    private long likeNumberId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CONTENT_ID")
    private Long contentId;

    public long getLikeNumberId() {
        return likeNumberId;
    }

    public void setLikeNumberId(long likeNumberId) {
        this.likeNumberId = likeNumberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
}
