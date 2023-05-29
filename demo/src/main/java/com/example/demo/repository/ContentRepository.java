package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.Content;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public interface ContentRepository {
    Content save(Content content);
    Optional<Content> findById(Long id);
    Optional<Content> findByTitle(String title);
    List<Content> findAll();

}
