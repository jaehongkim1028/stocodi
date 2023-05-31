package com.example.demo.controller;

import com.example.demo.domain.Content;
import com.example.demo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService){
        this.contentService = contentService;
    }

    @GetMapping("/contents/new")
    public String createForm(){
        return "contents/createContentForm";
    }

    @PostMapping("/contents/new")
    public String create(ContentForm form){
        Content content = new Content();
        //content.setContentID();
        //content.setEmail();
        content.setTitle(form.getTitle());
        content.setContent(form.getContent());
        content.setHashtag(form.getHashtag());
        content.setWriter(form.getWriter());
        content.setVideoLink(form.getVideoLink());
        content.setLikeCount(0);
        //content.setScrapCount();
        //content.setStorePlace();

        contentService.create(content);

        return "redirect:/";
    }

    @GetMapping("/contents")
    public String list(Model model){
        List<Content> contents = contentService.findContents();
        model.addAttribute("contents", contents);

        return "contents/contentList";
    }

    // Content 상세 페이지
    @GetMapping("/contents/{ContentId}")
    public String detail(@PathVariable Long contentId, Model model){
        Optional<Content> content = contentService.findOne(contentId);
        model.addAttribute("content", content.orElse(null));
        return "contents/contentDetail";
    }

    // 상세 페이지에서 Content 수정
    @GetMapping("/Contents/update/{contentId}")
    public String updateForm(@PathVariable Long contentId, Model model){
        Content content = contentService.findOne(contentId).get();
        model.addAttribute("content", content);

        return "contents/updateContent";
    }

    @PostMapping("/contents/update/{contentId}")
    public String update(@PathVariable Long contentId, Content newContent){
        contentService.update(contentId, newContent);

        return "redirect:/contents";
    }

    @GetMapping("/contents/delete/{contentId}")
    public String delete(@PathVariable long contentId){
        contentService.delete(contentId);

        return "redirect:/contents";
    }
}
