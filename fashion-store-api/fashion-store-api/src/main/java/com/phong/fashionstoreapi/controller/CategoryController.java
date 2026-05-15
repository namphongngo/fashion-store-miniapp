package com.phong.fashionstoreapi.controller;

import com.phong.fashionstoreapi.entity.Category;
import com.phong.fashionstoreapi.repository.CategoryRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/api/categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
