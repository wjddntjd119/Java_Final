package com.example.jeongwoosung_201930327.service;

import com.example.jeongwoosung_201930327.dto.ProductDto;
import com.example.jeongwoosung_201930327.dto.ProductResponseDto;
import com.example.jeongwoosung_201930327.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    List<ProductResponseDto> listProductByName(String name);

    Product getProductById(String productId);

    ProductResponseDto saveProduct(ProductDto productDto);

    List<ProductResponseDto> listAll();

    List<ProductResponseDto> listAllByOrderByPriceDesc();

    ProductResponseDto changeProductName(Long number, String name, int price, int stock) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
