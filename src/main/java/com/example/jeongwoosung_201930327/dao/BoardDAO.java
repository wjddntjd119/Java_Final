package com.example.jeongwoosung_201930327.dao;

import com.example.jeongwoosung_201930327.entity.Board;
import com.example.jeongwoosung_201930327.entity.Product;

import java.util.List;

public interface BoardDAO {
    Board insertBoard(Board board);
    Board selectBoard(long id);

    Board updateBoard(long id, String title, String contents) throws Exception;

    void deleteBoard(long id) throws Exception;

    //게시판 리스트
    List<Board> listAll();

    //작성일시 내림차순
    List<Board> listAllByOrderByCreatedAtDesc();

    //작성자를 통해 가져오기
    List<Board> listBoardByName(String user_name);
}
