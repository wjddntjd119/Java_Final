package com.example.jeongwoosung_201930327.dao.impl;

import com.example.jeongwoosung_201930327.dao.BoardDAO;

import com.example.jeongwoosung_201930327.entity.Board;
import com.example.jeongwoosung_201930327.entity.Product;
import com.example.jeongwoosung_201930327.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BoardDAOImpl implements BoardDAO {

    private final BoardRepository boardRepository;


    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository) {

        this.boardRepository = boardRepository;

    }

    @Override
    public Board insertBoard(Board board) {
        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }

    @Override
    public Board selectBoard(long id) {
        Board selectBoard = boardRepository.getReferenceById(id);
        return selectBoard;
    }

    @Override
    public Board updateBoard(long id, String title, String contents) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(id);

        Board updateBoard;
        if(selectedBoard.isPresent()) {
            Board board = selectedBoard.get();
            board.setTitle(title);
            board.setContents(contents);
            board.setUpdatedAt(LocalDateTime.now());

            updateBoard = boardRepository.save(board);
        } else throw new Exception();
        return updateBoard;
    }

    @Override
    public void deleteBoard(long id) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(id);

        if(selectedBoard.isPresent()) {
            Board board = selectedBoard.get();
            boardRepository.delete(board);
        } else throw new Exception();
    }

    @Override
    public List<Board> listAll() {
        return boardRepository.findAllBy();
    }

    @Override
    public List<Board> listAllByOrderByCreatedAtDesc() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Board> listBoardByName(String user_name) {
        return boardRepository.findByUserId(user_name);
    }
}
