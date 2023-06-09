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
        Board selectedBoard = boardRepository.findById(id);

        Board updateBoard;
        if(selectedBoard != null) {

            selectedBoard.setTitle(title);
            selectedBoard.setContents(contents);
            selectedBoard.setUpdatedAt(LocalDateTime.now());

            updateBoard = boardRepository.save(selectedBoard);
        } else throw new Exception();
        return updateBoard;
    }

    @Override
    public void deleteBoard(long id) throws Exception {
        Board selectedBoard = boardRepository.findById(id);

        if(selectedBoard != null) {
            boardRepository.delete(selectedBoard);
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

    //boardID 값으로 UsrId 찾기
    @Override
    public Board getBoardUserId(long id) {
        return boardRepository.findById(id);
    }
}
