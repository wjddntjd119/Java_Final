package com.example.jeongwoosung_201930327.repository;

import com.example.jeongwoosung_201930327.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByNameOrderByPriceDesc(String name);
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllBy();

}
