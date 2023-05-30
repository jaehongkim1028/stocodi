package com.example.demo.controller;

import com.example.demo.domain.Content;
import com.example.demo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        //content.setLikeCount();
        //content.setScrapCount();
        //content.setStorePlace();

        contentService.create(content);

        return "redirect:/";
    }

    @GetMapping("/articles")
    public String list(Model model){
        List<Content> contents = contentService.findContents();
        model.addAttribute("contents", contents);

        return "contents/contentList";
    }
}
