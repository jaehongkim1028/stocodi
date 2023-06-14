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
    public String GetRequest(@PathVariable String email, @PathVariable long contentId) {
        likeNumberService.likeORdislike(email, contentId);

        return "redirect:/contents/" + contentId;
    }

}
