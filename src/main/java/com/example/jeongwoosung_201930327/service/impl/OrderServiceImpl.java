package com.example.jeongwoosung_201930327.service.impl;

import com.example.jeongwoosung_201930327.dao.OrderDAO;
import com.example.jeongwoosung_201930327.dto.OrderDto;
import com.example.jeongwoosung_201930327.dto.OrderResponseDto;
import com.example.jeongwoosung_201930327.dto.ProductResponseDto;
import com.example.jeongwoosung_201930327.entity.Order;
import com.example.jeongwoosung_201930327.entity.Product;
import com.example.jeongwoosung_201930327.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public OrderResponseDto getOrder(long id) {
        Order order = orderDAO.selectOrder(id);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setUser_id(order.getUserId());
        orderResponseDto.setUser_name(order.getUserName());
        orderResponseDto.setId(order.getId());
        orderResponseDto.setProduct_name(order.getProductName());
        orderResponseDto.setProduct_id(order.getProductId());
        orderResponseDto.setPrice(order.getPrice());

        return orderResponseDto;
    }

    @Override
    public OrderResponseDto saveOrder(OrderDto orderDto) {
        Order order = new Order();

        order.setPrice(orderDto.getPrice());
        order.setUserId(orderDto.getUser_id());
        order.setUserName(orderDto.getUser_name());
        order.setProductId(orderDto.getProduct_id());
        order.setProductName(orderDto.getProduct_name());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order saveOrder = orderDAO.insertOrder(order);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(saveOrder.getId());
        orderResponseDto.setPrice(saveOrder.getPrice());
        orderResponseDto.setUser_id(saveOrder.getUserId());
        orderResponseDto.setUser_name(saveOrder.getUserName());
        orderResponseDto.setProduct_id(saveOrder.getProductId());
        orderResponseDto.setProduct_name(saveOrder.getProductName());

        return orderResponseDto;
    }

    @Override
    public List<OrderResponseDto> listOrderByUsrId(String userId) {
        List<Order> orders = orderDAO.listOrderByUsrId(userId);
        List<OrderResponseDto> orderResponseDtoList = orders.stream().map(
                order -> new OrderResponseDto(order)).collect(Collectors.toList());
        return orderResponseDtoList;
    }

    @Override
    public List<OrderResponseDto> listAll() {
        List<Order> orders = orderDAO.listAll();
        List<OrderResponseDto> orderResponseDtoList = orders.stream().map(
                order -> new OrderResponseDto(order)).collect(Collectors.toList());
        return orderResponseDtoList;
    }

    @Override
    public List<OrderResponseDto> listOrderByProductId(String productId) {
        List<Order> orders = orderDAO.listOrderByProductId(productId);
        List<OrderResponseDto> orderResponseDtoList = orders.stream().map(
                order -> new OrderResponseDto(order)).collect(Collectors.toList());
        return orderResponseDtoList;
    }
}
