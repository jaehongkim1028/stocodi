package com.example.demo.service;

import com.example.demo.domain.Content;
import com.example.demo.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ContentService {
    private final ContentRepository contentRepository;
    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Long create(Content content) {
        contentRepository.save(content);
        return content.getContentId();
    }

    public List<Content> findContents() {
        return contentRepository.findAll();
    }

    public Optional<Content> findOne(Long contentId) {
        return contentRepository.findById(contentId);
    }

    public Optional<Content> findByTitle(String contentTitle) {
        return contentRepository.findByTitle(contentTitle);
    }
}