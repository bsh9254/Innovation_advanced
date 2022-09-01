package com.example.intermediate.repository;


import com.example.intermediate.domain.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommentlikeRepository extends JpaRepository<Recommentlike, Long> {

    List<Recommentlike> findAllByRecomment(Recomment recomment);

}
