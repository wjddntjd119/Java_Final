package com.example.jeongwoosung_201930327.dao.impl;

import com.example.jeongwoosung_201930327.entity.Product;
import com.example.jeongwoosung_201930327.dao.ProductDAO;
import com.example.jeongwoosung_201930327.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;


    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;

    }

    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectProduct = productRepository.getReferenceById(number);
        return selectProduct;
    }


    @Override
    public List<Product> listProductByName(String name) {
        return productRepository.findByNameOrderByPriceDesc(name);
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAllBy();
    }

    @Override
    public List<Product> listAllByOrderByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }






    @Override
    public Product updateProductName(Long number, String name, int price, int stock) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updateProduct;
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else throw new Exception();
        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else throw new Exception();
    }

}
