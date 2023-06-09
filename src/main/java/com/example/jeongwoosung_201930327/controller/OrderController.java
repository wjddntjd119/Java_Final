package com.example.jeongwoosung_201930327.controller;

import com.example.jeongwoosung_201930327.dto.OrderDto;
import com.example.jeongwoosung_201930327.dto.OrderResponseDto;
import com.example.jeongwoosung_201930327.dto.ProductDto;
import com.example.jeongwoosung_201930327.dto.ProductResponseDto;
import com.example.jeongwoosung_201930327.entity.Product;
import com.example.jeongwoosung_201930327.service.OrderService;
import com.example.jeongwoosung_201930327.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "주문 정보 - 아이디를 통해 가져오기 - ADMIN만 볼 수 있음", description = "")
    public ResponseEntity<OrderResponseDto> getOrder(Long id) {
        OrderResponseDto orderResponseDto = orderService.getOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }
    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "주문 리스트 - ADMIN만 볼 수 있음", description = "")
    public ResponseEntity<List<OrderResponseDto>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.listAll());
    }
    @GetMapping("/listByProductId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "상품별 주문 리스트 - 상품 아이디을 통해 가져오기(ADMIN만 볼 수 있음)", description = "")
    public ResponseEntity<List<OrderResponseDto>> listByProductId(String productId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.listOrderByProductId(productId));
    }
    @GetMapping("/listByUserId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "상품별 주문 리스트 - 구매자 아이디을 통해 가져오기(ADMIN만 볼 수 있음)", description = "")
    public ResponseEntity<List<OrderResponseDto>> listByUserId(String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.listOrderByUsrId(userId));
    }


    @PostMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "주문(구매)등록 - USER만 등록", description = "")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderDto orderDto) throws Exception {
        Product product = productService.getProductById(orderDto.getProduct_id());
        if (product == null || product.getStock() == 0) {
            OrderResponseDto responseDto = new OrderResponseDto();
            responseDto.setMessage("Product is unavailable for purchase");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
        if (Long.parseLong(orderDto.getProduct_id()) == product.getNumber() && product.getStock() > 0) {
            product.setStock(product.getStock() - 1);
            ProductResponseDto productResponseDto = new ProductResponseDto(product.getNumber(),product.getName(),product.getPrice(),product.getStock());
            productService.changeProductName(product.getNumber(),product.getName(),product.getPrice(),product.getStock());
        }

        OrderResponseDto orderResponseDto = orderService.saveOrder(orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }
}
