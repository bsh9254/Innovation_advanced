package com.example.intermediate.repository;


import com.example.intermediate.domain.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostlikeRepository extends JpaRepository<Postlike, Long> {

    List<Postlike> findAllByPost(Post post);

}
