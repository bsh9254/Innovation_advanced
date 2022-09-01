package com.example.intermediate.repository;


import com.example.intermediate.domain.Comment;
import com.example.intermediate.domain.Commentlike;

import java.util.List;

import com.example.intermediate.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentlikeRepository extends JpaRepository<Commentlike, Long> {
    ;
    List<Commentlike> findAllByComment(Comment comment);

}
