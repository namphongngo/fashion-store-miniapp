package com.phong.fashionstoreapi.repository;

import com.phong.fashionstoreapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);
    Optional<Product> findById(Long id);
}
