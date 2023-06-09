package com.example.jeongwoosung_201930327.dto;

import com.example.jeongwoosung_201930327.entity.Board;
import com.example.jeongwoosung_201930327.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponseDto {
    private long id;
    private int price;
    private String product_id;
    private String product_name;
    private String user_id;
    private String user_name;

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    private LocalDateTime created_at;

    private LocalDateTime updated_at;
    public OrderResponseDto() {}

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.price = order.getPrice();
        this.product_id = order.getProductId();
        this.product_name = order.getProductName();
        this.user_name = order.getUserName();
        this.user_id = order.getUserId();
        this.created_at = order.getCreatedAt();
        this.updated_at = order.getUpdatedAt();
    }

    public OrderResponseDto(long id, int price, String product_id, String product_name,String user_name, String user_id, LocalDateTime created_at,LocalDateTime updated_at) {
        this.id = id;
        this.price = price;
        this.product_id = product_id;
        this.product_name = product_name;
        this.user_name = user_name;
        this.user_id = user_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
