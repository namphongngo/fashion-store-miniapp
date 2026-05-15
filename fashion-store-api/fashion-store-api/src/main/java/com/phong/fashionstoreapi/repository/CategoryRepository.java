package com.phong.fashionstoreapi.repository;

import com.phong.fashionstoreapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
