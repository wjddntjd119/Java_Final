package com.example.jeongwoosung_201930327.service.impl;

import com.example.jeongwoosung_201930327.dao.ProductDAO;
import com.example.jeongwoosung_201930327.dto.ProductDto;
import com.example.jeongwoosung_201930327.dto.ProductResponseDto;
import com.example.jeongwoosung_201930327.entity.Product;
import com.example.jeongwoosung_201930327.repository.ProductRepository;
import com.example.jeongwoosung_201930327.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO, ProductRepository productRepository) {
        this.productDAO = productDAO;
        this.productRepository = productRepository;
    }

    //상품 정보 아이디를 통해 가져오기
    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }



    @Override
    public List<ProductResponseDto> listProductByName(String name) {
        List<Product> products = productDAO.listProductByName(name);
        List<ProductResponseDto> productResponseDtoList = products.stream().map(
                product -> new ProductResponseDto(product)).collect(Collectors.toList());
        return productResponseDtoList;
    }


    @Override
    public List<ProductResponseDto> listAll() {
        List<Product> products = productDAO.listAll();
        List<ProductResponseDto> productResponseDtoList = products.stream().map(
                product -> new ProductResponseDto(product)).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public List<ProductResponseDto> listAllByOrderByPriceDesc() {
        List<Product> products = productDAO.listAllByOrderByPriceDesc();
        List<ProductResponseDto> productResponseDtoList = products.stream().map(
                product -> new ProductResponseDto(product)).collect(Collectors.toList());
        return productResponseDtoList;
    }


    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());
        return productResponseDto;
    }

    public Product getProductById(String productId) {
        Long id = Long.parseLong(productId);
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }


    @Override
    public ProductResponseDto changeProductName(Long number, String name, int price, int stock) throws Exception {
        Product changeProduct = productDAO.updateProductName(number, name, price, stock);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changeProduct.getNumber());
        productResponseDto.setName(changeProduct.getName());
        productResponseDto.setPrice(changeProduct.getPrice());
        productResponseDto.setStock(changeProduct.getStock());
        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}
