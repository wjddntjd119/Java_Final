package com.example.jeongwoosung_201930327.service;



import com.example.jeongwoosung_201930327.dto.OrderDto;
import com.example.jeongwoosung_201930327.dto.OrderResponseDto;
import com.example.jeongwoosung_201930327.entity.Order;

import java.util.List;

public interface OrderService {
    OrderResponseDto getOrder(long id);

    OrderResponseDto saveOrder(OrderDto orderDto);


    List<OrderResponseDto> listOrderByUsrId(String userId);
    List<OrderResponseDto> listAll();

    List<OrderResponseDto> listOrderByProductId(String productId);
}
