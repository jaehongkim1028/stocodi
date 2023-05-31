package com.example.demo.controller;

import com.example.demo.domain.LikeNumber;
import com.example.demo.repository.JpaLikeNumberRepository;
import com.example.demo.service.LikeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class LikeNumberController {

    private final LikeNumberService likeNumberService;

    @Autowired
    public LikeNumberController(LikeNumberService likeNumberService){
        this.likeNumberService = likeNumberService;
    }

    @GetMapping("/contents/like/{email}/{contentId}")
    public void likeORdislike(@PathVariable String email, @PathVariable long contentId){
        //List<LikeNumber> likeNumber = JpaLikeNumberRepository.findByEmailAndContentId(email, contentId);

//        if(JpaLikeNumberRepository.findByEmailAndContentId(email, contentId).isEmpty()){
//            //해당 조건에 만족하는 좋아요가 없음 (좋아요 생성)
//            LikeNumber newlikeNumber = new LikeNumber();
//
//            newlikeNumber.setContentId(contentId);
//            newlikeNumber.setEmail(email);
//        }
//        else{
//            //해당 조건에 만족하는 좋아요가 있음 (좋아요 삭제)
//            likeNumberService.delete(email, contentId);
//        }
    }
}
