package com.phong.fashionstoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favorites")
@Data
public class Favorite {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;
}
