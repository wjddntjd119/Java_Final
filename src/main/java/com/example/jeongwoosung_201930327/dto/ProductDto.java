package com.example.jeongwoosung_201930327.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {

    private String name;
    private int price;
    private int stock;


}