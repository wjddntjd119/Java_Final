package com.example.jeongwoosung_201930327.repository;

import com.example.jeongwoosung_201930327.entity.Order;
import com.example.jeongwoosung_201930327.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(String userId);
    List<Order> findByProductId(String productId);

    //주문리스트
    List<Order> findAllBy();
}
