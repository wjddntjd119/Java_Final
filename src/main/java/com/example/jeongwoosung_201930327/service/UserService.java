package com.example.jeongwoosung_201930327.service;

import com.example.jeongwoosung_201930327.dto.ProductResponseDto;
import com.example.jeongwoosung_201930327.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> listAll();

    List<UserDto> listOrderByName();

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
