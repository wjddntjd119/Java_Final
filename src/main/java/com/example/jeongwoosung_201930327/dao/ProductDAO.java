package com.example.jeongwoosung_201930327.dao;

import com.example.jeongwoosung_201930327.entity.Product;

import java.util.List;

public interface ProductDAO {

    Product insertProduct(Product product);

    Product selectProduct(Long number);



    List<Product> listProductByName(String name);
    List<Product> listAll();

    List<Product> listAllByOrderByPriceDesc();


    Product updateProductName(Long number, String name, int price, int stock) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
