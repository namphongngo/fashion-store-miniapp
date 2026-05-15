package com.phong.fashionstoreapi.controller;

import com.phong.fashionstoreapi.entity.Product;
import com.phong.fashionstoreapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/api/products/category/{id}")
    public List<Product> getProductsByCategory(
            @PathVariable("id") Long id
    ) {
        return productRepository.findByCategoryId(id);
    }

    @GetMapping("/api/products/{id}")
    public Optional<Product> getProductById(
            @PathVariable("id") Long id
    ) {
        return productRepository.findById(id);
    }
}
