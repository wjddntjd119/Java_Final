package com.example.jeongwoosung_201930327.service;

import com.example.jeongwoosung_201930327.dto.BoardDto;
import com.example.jeongwoosung_201930327.dto.BoardResponseDto;
import com.example.jeongwoosung_201930327.dto.ProductDto;
import com.example.jeongwoosung_201930327.dto.ProductResponseDto;

import java.util.List;

public interface BoardService {
    String getBoardUserId(long id);

    BoardResponseDto getBoard(long id);

    List<BoardResponseDto> listBoardByName(String name);


    BoardResponseDto saveBoard(BoardDto boardDto, String token);

    List<BoardResponseDto> listAll();

    List<BoardResponseDto> listAllByOrderByCreatedAtDesc();

    BoardResponseDto changeBoard(long id, String title, String contents) throws Exception;

    void deleteBoard(long id) throws Exception;
}
