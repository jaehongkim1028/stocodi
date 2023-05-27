package com.example.demo.repository;

import com.example.demo.domain.Content;
import com.example.demo.domain.LikeNumber;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ContentRepository extends JpaRepository<Like, Long>{
    Optional<LikeNumber> findByMemberAndBoard(User user, Content content);
}
