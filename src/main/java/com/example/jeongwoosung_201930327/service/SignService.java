package com.example.jeongwoosung_201930327.service;
import com.example.jeongwoosung_201930327.dto.SignInResultDto;
import com.example.jeongwoosung_201930327.dto.SignUpResultDto;

public interface SignService {
    SignUpResultDto signUp(String id, String password, String name, String email, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;
}
