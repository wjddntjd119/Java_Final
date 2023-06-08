package com.example.jeongwoosung_201930327.service.impl;

import com.example.jeongwoosung_201930327.dao.BoardDAO;
import com.example.jeongwoosung_201930327.dao.ProductDAO;
import com.example.jeongwoosung_201930327.dto.BoardDto;
import com.example.jeongwoosung_201930327.dto.BoardResponseDto;
import com.example.jeongwoosung_201930327.dto.ProductResponseDto;
import com.example.jeongwoosung_201930327.entity.Board;
import com.example.jeongwoosung_201930327.entity.Product;
import com.example.jeongwoosung_201930327.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public BoardResponseDto getBoard(long id) {
        Board board = boardDAO.selectBoard(id);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(board.getId());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContents(board.getContents());
        boardResponseDto.setCreated_at(board.getCreatedAt());

        return boardResponseDto;
    }

    @Override
    public List<BoardResponseDto> listBoardByName(String name) {
        List<Board> boards = boardDAO.listBoardByName(name);
        List<BoardResponseDto> boardResponseDtoList = boards.stream().map(
                board -> new BoardResponseDto(board)).collect(Collectors.toList());
        return boardResponseDtoList;
    }

    @Override
    public BoardResponseDto saveBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContents(boardDto.getContents());
        ////////////////////////////////여기 id랑 이름 입력하는 방법 찾아보기
        board.setCreatedAt(LocalDateTime.now());
        board.setUpdatedAt(LocalDateTime.now());

        Board saveBoard = boardDAO.insertBoard(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setTitle(saveBoard.getTitle());
        boardResponseDto.setContents(saveBoard.getContents());
        ////////////////////////////////여기 id랑 이름 입력하는 방법 찾아보기

        return boardResponseDto;
    }

    @Override
    public List<BoardResponseDto> listAll() {
        List<Board> boards = boardDAO.listAll();
        List<BoardResponseDto> boardResponseDtoList = boards.stream().map(
                board -> new BoardResponseDto(board)).collect(Collectors.toList());
        return boardResponseDtoList;
    }

    @Override
    public List<BoardResponseDto> listAllByOrderByCreatedAtDesc() {
        List<Board> boards = boardDAO.listAllByOrderByCreatedAtDesc();
        List<BoardResponseDto> boardResponseDtoList = boards.stream().map(
                board -> new BoardResponseDto(board)).collect(Collectors.toList());
        return boardResponseDtoList;
    }

    @Override
    public BoardResponseDto changeBoard(long id, String title, String contents) throws Exception {
        Board changeBoard = boardDAO.updateBoard(id, title, contents);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(changeBoard.getId());
        boardResponseDto.setTitle(changeBoard.getTitle());
        boardResponseDto.setUpdated_at(changeBoard.getUpdatedAt());
        return boardResponseDto;
    }

    @Override
    public void deleteBoard(long id) throws Exception {
        boardDAO.deleteBoard(id);

    }
}
