package com.example.jeongwoosung_201930327.dao;

import com.example.jeongwoosung_201930327.entity.Order;
import com.example.jeongwoosung_201930327.entity.Product;

import java.util.List;

public interface OrderDAO {
    Order insertOrder(Order order);
    //get 주문정보
    Order selectOrder(long id);

    List<Order> listOrderByUsrId(String userId);
    List<Order> listAll();

    List<Order> listOrderByProductId(String productId);

}
