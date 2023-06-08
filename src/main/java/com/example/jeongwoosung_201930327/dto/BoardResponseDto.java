package com.example.jeongwoosung_201930327.dto;

import com.example.jeongwoosung_201930327.entity.Board;
import com.example.jeongwoosung_201930327.entity.Product;

import java.time.LocalDateTime;

public class BoardResponseDto {
    private long id;
    private String contents;
    private String title;
    private String user_id;
    private String user_name;
    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public BoardResponseDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.contents = board.getContents();
        this.title = board.getTitle();
        this.user_id = board.getUserId();
        this.created_at = board.getCreatedAt();
        this.updated_at = board.getUpdatedAt();
    }

    public BoardResponseDto(long id, String contents, String title, String user_id, LocalDateTime created_at,LocalDateTime updated_at) {
        this.id = id;
        this.contents = contents;
        this.title = title;
        this.user_id = user_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
