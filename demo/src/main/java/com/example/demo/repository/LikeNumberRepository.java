package com.example.demo.repository;

import com.example.demo.domain.LikeNumber;

import java.util.Optional;

public interface LikeNumberRepository {
    LikeNumber save(LikeNumber likeNumber);

    Optional<LikeNumber> findByEmail(String email);
    Optional<LikeNumber> findByContentId(Long ContentId);
    Optional<LikeNumber> findByEmailAndContentId(String email, Long ContentId);
    void delete(String email, Long contentId);
}
