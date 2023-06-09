package com.example.jeongwoosung_201930327.controller;

import com.example.jeongwoosung_201930327.config.security.JwtTokenProvider;
import com.example.jeongwoosung_201930327.dto.*;
import com.example.jeongwoosung_201930327.service.BoardService;
import com.example.jeongwoosung_201930327.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public BoardController(BoardService boardService, JwtTokenProvider jwtTokenProvider) {
        this.boardService = boardService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/")
    @Operation(summary = "게시글 정보 -아이디를 통해가져오기 - 누구나", description = "")
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @Operation(summary = "게시글 등록 - USER or ADMIN 권한이 있어야 등록가능", description = "")
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardDto boardDto,Principal principal) {
        String tokenUserId = principal.getName();
        BoardResponseDto boardResponseDto = boardService.saveBoard(boardDto,tokenUserId);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PutMapping()
    @Operation(summary = "게시글 수정- 본인이 작성한 글만 수정가능", description = "")
    public ResponseEntity<BoardResponseDto> changeBoardName(@RequestBody ChangeBoardDto changeBoardDto, Principal principal) throws Exception{
        String tokenUserId = principal.getName();
        String boardUserId = boardService.getBoardUserId(changeBoardDto.getId());
        if(!boardUserId.equals(tokenUserId)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        BoardResponseDto boardResponseDto = boardService.changeBoard(changeBoardDto.getId(), changeBoardDto.getTitle(), changeBoardDto.getContents());
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping()
    @Operation(summary = "게시글 삭제 - 본인이 작성한 글만 삭제가능", description = "")
    public ResponseEntity<String> deleteBoard(Long number, Principal principal) throws Exception{
        String tokenUserId = principal.getName();
        String boardUserId = boardService.getBoardUserId(number);
        if(!boardUserId.equals(tokenUserId)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        boardService.deleteBoard(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
