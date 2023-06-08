package com.example.jeongwoosung_201930327.controller;

import com.example.jeongwoosung_201930327.dto.ChangeProductDto;
import com.example.jeongwoosung_201930327.dto.ProductDto;
import com.example.jeongwoosung_201930327.dto.ProductResponseDto;
import com.example.jeongwoosung_201930327.service.ProductService;
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
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponseDto>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.listAll());
    }
    @GetMapping("/listOrderByPrice")
    public ResponseEntity<List<ProductResponseDto>> listAllOrderByPrice() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.listAllByOrderByPriceDesc());
    }

    @GetMapping("/byName")
    public ResponseEntity<List<ProductResponseDto>> listProductByName(String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.listProductByName(name));
    }



    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductDto changeProductDto) throws Exception{
        ProductResponseDto productResponseDto = productService.changeProductName(changeProductDto.getNumber(), changeProductDto.getName(), changeProductDto.getPrice(), changeProductDto.getStock());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
