package com.example.jeongwoosung_201930327.dto;

import com.example.jeongwoosung_201930327.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String name;
    private String uid;
    private String password;
    private String email;

    public UserDto(User user){
        this.name = user.getName();
        this.uid = user.getUid();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
