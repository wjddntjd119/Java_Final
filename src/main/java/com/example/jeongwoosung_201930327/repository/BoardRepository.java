package com.example.jeongwoosung_201930327.repository;

import com.example.jeongwoosung_201930327.entity.Board;
import com.example.jeongwoosung_201930327.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByUserId(String name);
    List<Board> findAllByOrderByCreatedAtDesc();
    List<Board> findAllBy();

}
