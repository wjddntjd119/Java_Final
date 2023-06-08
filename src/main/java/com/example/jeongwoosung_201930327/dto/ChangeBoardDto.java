package com.example.jeongwoosung_201930327.dto;

import java.time.LocalDateTime;

public class ChangeBoardDto {
    private long id;
    private String title;

    private String contents;
    private LocalDateTime updatedAt;

    public ChangeBoardDto(long id, String title, String contents, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ChangeBoardDto() {}
}
