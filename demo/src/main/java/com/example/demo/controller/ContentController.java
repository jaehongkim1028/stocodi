package com.example.demo.controller;

import com.example.demo.domain.Content;
import com.example.demo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService){
        this.contentService = contentService;
    }

    @GetMapping("/contents/new")
    public String createForm(){
        return "/";
    }

    @PostMapping("/contents/new")
    @ResponseBody
    public ResponseEntity<String> create(RequestEntity<ContentForm> requestEntity) {
        ContentForm form = requestEntity.getBody();

        Content content = new Content();
        content.setContentID(form.getContentID());
        //content.setEmail();
        content.setTitle(form.getTitle());
        content.setContent(form.getContent());
        content.setHashtags(form.getHashtags());
        content.setWriter(form.getWriter());
        content.setYoutubeId(form.getYoutubeId());
        content.setThumbnailUrl(form.getThumbnailUrl());
        content.setLikeCount(0);

        contentService.create(content);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(UriComponentsBuilder.fromPath("/").build().toUri());

        return null;
    }

    @GetMapping("/contents")
    public ResponseEntity<List<Content>> list() {
        List<Content> contents = contentService.findContents();
        return ResponseEntity.ok(contents);
    }

    @GetMapping("/")
    public ResponseEntity<List<Content>> findThree() {
        List<Content> contents = new ArrayList<>();

        Optional<Content> content1 = contentService.findOne(1L);
        Optional<Content> content2 = contentService.findOne(2L);
        Optional<Content> content3 = contentService.findOne(3L);

        if (content1.isPresent()) {
            contents.add(content1.get());
        }

        if (content2.isPresent()) {
            contents.add(content2.get());
        }

        if (content3.isPresent()) {
            contents.add(content3.get());
        }

        return ResponseEntity.ok(contents);
    }


    // Content 상세 페이지
    @GetMapping("/contents/{ContentId}")
    public String detail(@PathVariable Long contentId, Model model){
        Optional<Content> content = contentService.findOne(contentId);
        model.addAttribute("content", content.orElse(null));
        return "contents/contentDetail";
    }

    // Content 수정
    @GetMapping("/Contents/update/{contentId}")
    public String updateForm(@RequestParam @PathVariable Long contentId, Model model){
        Content content = contentService.findOne(contentId).get();
        model.addAttribute("content", content);

        return "contents/updateContent";
    }

    @PostMapping("/contents/update/{contentId}")
    public String update(@PathVariable Long contentId, Content newContent){
        contentService.update(contentId, newContent);

        return "redirect:/contents";
    }

    // Content 삭제
    @GetMapping("/contents/delete/{contentId}")
    public String delete(@PathVariable long contentId){
        contentService.delete(contentId);

        return "redirect:/contents";
    }
}
