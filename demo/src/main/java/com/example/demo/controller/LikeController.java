package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import com.example.demo.controller.LikeRequest;
import com.example.demo.domain.HttpResponseEntity.ResponseResult;
import com.example.demo.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.success;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("demo")

public class LikeController {
    private LikeService likeService;

    @PostMapping
    public ResponseResult<?> insert(@RequestBody @Valid LikeRequest likeRequest) {
        likeService.insert(likeRequest);
        return success(null);
    }

    @DeleteMapping
    public ResponseResult<?> delete(@RequestBody @Valid LikeRequest likeRequest) {
        likeService.delete(likeRequest);
        return success(null);
    }
}
