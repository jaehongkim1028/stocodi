package com.example.demo.service;

import com.example.demo.domain.Content;
//import com.example.demo.exception.NotFoundException;
//import com.example.demo.controller.LikeRequest;
//import com.example.demo.domain.LikeNumber;
//import com.example.demo.domain.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//
//public class LikeService {
//    private final LikeRepository likeRepository;
//    private final UserRepository userRepository;
//    private final ContentRepository contentRepository;
//
//    @Transactional
//    public void insert(LikeRequest likeRequest) throws Exception {
//
//        User user = userRepository.findById(likeRequest.getUserId())
//                .orElseThrow(() -> new NotFoundException("Could not found user id : " + likeRequest.getUserId()));
//
//        Content content = contentRepository.findById(likeRequest.getContentId())
//                .orElseThrow(() -> new NotFoundException("Could not found content id : " + likeRequest.getContentId()));
//
//        // 이미 좋아요 되어있으면 에러 반환
//        if (likeRepository.findByUserAndContent(user, content).isPresent()){
//            //TODO 409에러로 변경
//            throw new Exception();
//        }
//
//        LikeNumber likeNumber = LikeNumber.builder()
//                .content(content)
//                .user(user)
//                .build();
//
//        likeRepository.save(likeNumber);
//    }
//
//    @Transactional
//    public void delete(LikeRequest likeRequest) {
//
//        User user = userRepository.findById(likeRequest.getUserId())
//                .orElseThrow(() -> new NotFoundException("Could not found user id : " + likeRequest.getUserId()));
//
//        Content content = contentRepository.findById(likeRequest.getContentId())
//                .orElseThrow(() -> new NotFoundException("Could not found content id : " + likeRequest.getBoardId()));
//
//        LikeNumber likeNumber = likeRepository.findByUserAndContent(user, content)
//                .orElseThrow(() -> new NotFoundException("Could not found like id"));
//
//        likeRepository.delete(likeNumber);
//    }
//}
