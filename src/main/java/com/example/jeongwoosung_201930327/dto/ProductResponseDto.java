package com.example.jeongwoosung_201930327.dto;

import com.example.jeongwoosung_201930327.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;
    public ProductResponseDto(){}

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public ProductResponseDto(Product product) {
        this.number = product.getNumber();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();

    }

    public ProductResponseDto(Long number, String name, int price, int stock) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;

    }


}