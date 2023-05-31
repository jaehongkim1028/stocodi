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
    public LikeNumberService(LikeNumberRepository likeNumberRepository){
        this.likeNumberRepository = likeNumberRepository;
    }

    //좋아요 생성
    public Long create(LikeNumber likeNumber){
        likeNumberRepository.save(likeNumber);

        return likeNumber.getLikeNumberId();
    }

    // 조건에 맞는 아이디를 통해 해당 게시글에 좋아요를 누른 적이 있는지
    public Optional<LikeNumber> findOne(String email, Long ContentId){
        return likeNumberRepository.findByEmailAndContentId(email, ContentId);
    }

    public void delete(String email, Long contentId){
        likeNumberRepository.delete(email, contentId);
    }
}
