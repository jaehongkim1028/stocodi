package com.example.demo.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeRequest {
    private Long UserId;
    private Long ContentId;

    public LikeRequest(Long UserId, Long ContentId) {
        this.UserId = UserId;
        this.ContentId = ContentId;
    }
}