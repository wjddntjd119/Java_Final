package com.example.jeongwoosung_201930327.controller;

import com.example.jeongwoosung_201930327.dto.ChangeProductDto;
import com.example.jeongwoosung_201930327.dto.ProductDto;
import com.example.jeongwoosung_201930327.dto.ProductResponseDto;
import com.example.jeongwoosung_201930327.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    @Operation(summary = "상품 정보 - 아이디를 통해 가져오기", description = "")
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/list")
    @Operation(summary = "상품 리스트 - 누구나 볼 수 있음", description = "")
    public ResponseEntity<List<ProductResponseDto>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.listAll());
    }
    @GetMapping("/listOrderByPrice")
    @Operation(summary = "상품 리스트(가격순으로: 내림차순). 누구나 볼 수 있음", description = "")
    public ResponseEntity<List<ProductResponseDto>> listAllOrderByPrice() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.listAllByOrderByPriceDesc());
    }

    @GetMapping("/byName")
    @Operation(summary = "상품 리스트 - 이름을 통해 가져오기(이름은 중복가능) 누구나 볼 수 있음", description = "")
    public ResponseEntity<List<ProductResponseDto>> listProductByName(String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.listProductByName(name));
    }



    @PostMapping()
    @Operation(summary = "상품 등록 - ADMIN만", description = "")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping()
    @Operation(summary = "상품 수정 - 상품명, 가격, 재고 수정 가능, ADMIN만", description = "")
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductDto changeProductDto) throws Exception{
        ProductResponseDto productResponseDto = productService.changeProductName(changeProductDto.getNumber(), changeProductDto.getName(), changeProductDto.getPrice(), changeProductDto.getStock());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping()
    @Operation(summary = "상품 삭제 - ADMIN만", description = "")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
