package com.phong.fashionstoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
