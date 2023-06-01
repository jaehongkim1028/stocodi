package com.example.demo.service;

import com.example.demo.domain.LikeNumber;
import com.example.demo.repository.LikeNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class LikeNumberService {
    private final LikeNumberRepository likeNumberRepository;

    @Autowired
    public LikeNumberService(LikeNumberRepository likeNumberRepository) {
        this.likeNumberRepository = likeNumberRepository;
    }

    //좋아요 생성
    public Long create(LikeNumber likeNumber) {
        likeNumberRepository.save(likeNumber);

        return likeNumber.getLikeNumberId();
    }

    // 조건에 맞는 아이디로 해당 게시글에 누른 좋아요 검색
    public Optional<LikeNumber> findOne(String email, Long contentId) {
        return likeNumberRepository.findByEmailAndContentId(email, contentId);
    }

    public void likeORdislike(String email, long contentId) {
        if (findOne(email, contentId).isEmpty()) {
            //해당 조건에 만족하는 좋아요가 없음 (좋아요 생성)
            LikeNumber likeNumber = new LikeNumber();
            //LikeNumber likeNumber;

            likeNumber.setContentId(contentId);
            likeNumber.setEmail(email);

            create(likeNumber);
        } else {
            //해당 조건에 만족하는 좋아요가 있음 (좋아요 삭제)
            likeNumberRepository.delete(email, contentId);
        }
    }
}
