package com.example.intermediate.repository;

import com.example.intermediate.domain.Comment;
import com.example.intermediate.domain.Post;
import java.util.List;

import com.example.intermediate.domain.Recomment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommentRepository extends JpaRepository<Recomment, Long> {
    List<Recomment> findAllByComment(Comment comment);
}