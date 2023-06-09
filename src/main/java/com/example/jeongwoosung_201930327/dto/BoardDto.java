package com.example.jeongwoosung_201930327.dto;

import com.example.jeongwoosung_201930327.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardDto {
    private String contents;
    private String title;
    private  String user_name;

    public BoardDto(Board board){
        this.contents = board.getContents();
        this.title = board.getTitle();
        this.user_name = board.getUserName();
    }

}
