package com.example.demo.controller;

import java.io.FileNotFoundException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/video")
public class ContentController {
    private final String TEMPLATE_DIR = "video/";
    private final String UPLOAD_DIR = "D:\\upload\\";

    public String videoName = "IMG_5843.mp4";
    //  콘텐츠 비디오 파일명

    // 1. 웹경로에 의한 스트리밍
    // 스프링프로젝트의 /resources/static/video 폴터에 동영상을 넣어 서비스
    @GetMapping("")
    public String videoIndex(Model model) {
        model.addAttribute("videoUrl", "/video/"+ videoName);
        return TEMPLATE_DIR + "video";
    }

    // 2. 동영상 파일을 Resource 객체로 내려주는 경우
    // 파일이 전체 내려오지 않아도 동영상 플레이가 시작된다. 단 중간에 플레이 구간을 선택 시 다시 파일을 받기 시작한다.
    @GetMapping("/resource")
    public String videoResource(Model model) {
        model.addAttribute("videoUrl", "/video/"+ videoName);
        return TEMPLATE_DIR + "video";
    }

    @GetMapping("/resource/{fileName}")
    public ResponseEntity<Resource> vidoeResourceFileName(@PathVariable String fileName) throws FileNotFoundException {
        String fileFullPath = UPLOAD_DIR + fileName;
        Resource resource = new FileSystemResource(fileFullPath);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName + "");
        headers.setContentType(MediaType.parseMediaType("video/mp4"));
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }
}

/*
            <!DOCTYPE html>
            <html xmlns:th="http://www.thymeleaf.org">
            <head>
            <meta charset="UTF-8">
            <title>Insert title here</title>
            </head>
            <body>
            <video controls="controls" th:src="${videoUrl}" width="400" autoplay="autoplay"></video>
            </body>
            </html>
 */