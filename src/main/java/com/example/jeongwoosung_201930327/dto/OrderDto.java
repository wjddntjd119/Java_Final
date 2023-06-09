package com.example.jeongwoosung_201930327.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class OrderDto {

    private int price;
    private String product_id;
    private String product_name;
    private String user_id;
    private String user_name;


}
