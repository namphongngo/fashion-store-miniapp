package com.phong.fashionstoreapi.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bil_details")
@Data
public class BillDetail {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private String size;
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
