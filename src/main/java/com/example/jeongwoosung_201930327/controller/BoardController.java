package com.example.jeongwoosung_201930327.controller;

import com.example.jeongwoosung_201930327.dto.*;
import com.example.jeongwoosung_201930327.service.BoardService;
import com.example.jeongwoosung_201930327.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    @Operation(summary = "", description = "")
    public ResponseEntity<BoardResponseDto> getBoard(long id) {
        BoardResponseDto boardResponseDto = boardService.getBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @GetMapping("/list")
    @Operation(summary = "게시판 리스트 - 누구나", description = "")
    public ResponseEntity<List<BoardResponseDto>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.listAll());
    }
    @GetMapping("/listOrderByCreatedAt")
    @Operation(summary = "게시글 리스트 - 작성일시 순(내림차순)(누구나, 작성자 중복 등록 가능)", description = "")
    public ResponseEntity<List<BoardResponseDto>> listAllByOrderByCreatedAtDesc() {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.listAllByOrderByCreatedAtDesc());
    }

    @GetMapping("/byUserId")
    @Operation(summary = "게시글 리스트 - 작성자를 통해 가져오기(누구나, 작성자 중복 등록 가능)", description = "")
    public ResponseEntity<List<BoardResponseDto>> listBoardByName(String name) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.listBoardByName(name));
    }



    @PostMapping()
    @Operation(summary = "게시글 등록 - USER or ADMIN 권한이 있어야 등록가능", description = "")
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardDto boardDto) {
        BoardResponseDto boardResponseDto = boardService.saveBoard(boardDto);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PutMapping()
    @Operation(summary = "게시글 수정- 본인이 작성한 글만 수정가능", description = "")
    public ResponseEntity<BoardResponseDto> changeBoardName(@RequestBody ChangeBoardDto changeBoardDto) throws Exception{
        BoardResponseDto boardResponseDto = boardService.changeBoard(changeBoardDto.getId(), changeBoardDto.getTitle(), changeBoardDto.getContents());
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping()
    @Operation(summary = "게시글 삭제 - 본인이 작성한 글만 삭제가능", description = "")
    public ResponseEntity<String> deleteBoard(Long number) throws Exception{
        boardService.deleteBoard(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
