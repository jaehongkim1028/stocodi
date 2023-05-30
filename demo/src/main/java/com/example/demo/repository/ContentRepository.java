package com.example.demo.repository;

import com.example.demo.domain.Content;

import java.util.List;
import java.util.Optional;

public interface ContentRepository {
    Content save(Content content);

    Optional<Content> findById(Long contentId);
    List<Content> findAll();
}
