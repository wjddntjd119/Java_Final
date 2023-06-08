package com.example.jeongwoosung_201930327.controller;

import com.example.jeongwoosung_201930327.dto.UserDto;
import com.example.jeongwoosung_201930327.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserDto>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAll());
    }
    @GetMapping("/listOrderByName")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserDto>> listOrderByName(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listOrderByName());
    }



}
