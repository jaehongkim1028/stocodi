package com.example.demo.controller;

//import com.example.demo.service.CommentService;
import com.example.demo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Content;
import com.example.demo.repository.ContentRepository;

@Controller
public class ContentController {

    //    @Autowired
//    //private ContentServiceImpl contentService;
//
//    @Autowired
//    private ContentRepository contentRepository;
//
//    //게시글 목록
//    @GetMapping("/list")
//    public String list(@PageableDefault Pageable pageable, Model model) {
//        model.addAttribute("contentList", contentService.findContentList(pageable));
//        return "/content/list";
//    }
//
//    //게시글 생성
//    @PostMapping
//    public ResponseEntity<?> postBoard(@RequestBody Content content) {
//        contentRepository.save(content);
//
//        return new ResponseEntity<>("{}", HttpStatus.CREATED);
//    }
//
//    /*
//    //게시글 수정
//    @PutMapping("/{idx}")
//    public ResponseEntity<?> putBoard(@PathVariable("idx") Long idx, @RequestBody Content content) {
//        Content updateContent = contentRepository.getOne(idx);
//        updateContent.setTitle(content.getTitle());
//        updateContent.setContent(content.getContent());
//        contentRepository.save(updateContent);
//
//        return new ResponseEntity<>("{}", HttpStatus.OK);
//    }*/
//
//    // 게시글 삭제
//    @DeleteMapping("/{idx}")
//    public ResponseEntity<?> deleteContent(@PathVariable("idx") Long idx) {
//        contentRepository.deleteById(idx);
//
//        return new ResponseEntity<>("{}", HttpStatus.OK);
//    }
    public final ContentService contentService;
    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/contents/new")
    public String createForm() {
        return "contents/content";
    }



}