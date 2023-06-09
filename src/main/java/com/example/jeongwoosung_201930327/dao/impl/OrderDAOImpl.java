package com.example.jeongwoosung_201930327.dao.impl;

import com.example.jeongwoosung_201930327.dao.OrderDAO;
import com.example.jeongwoosung_201930327.entity.Board;
import com.example.jeongwoosung_201930327.entity.Order;
import com.example.jeongwoosung_201930327.entity.Product;
import com.example.jeongwoosung_201930327.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDAOImpl implements OrderDAO {
    private final OrderRepository orderRepository;

    public OrderDAOImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order insertOrder(Order order) {
        Order saveOrder = orderRepository.save(order);
        return saveOrder;
    }

    @Override
    public Order selectOrder(long id) {
        Order selectOrder = orderRepository.getReferenceById(id);
        return selectOrder;
    }

    @Override
    public List<Order> listOrderByUsrId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.findAllBy();
    }

    @Override
    public List<Order> listOrderByProductId(String productId) {
        return orderRepository.findByProductId(productId);
    }


}
