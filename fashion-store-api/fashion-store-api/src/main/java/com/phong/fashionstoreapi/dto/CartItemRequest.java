package com.phong.fashionstoreapi.dto;

import lombok.Data;

@Data
public class CartItemRequest {

    private Long productId;

    private Integer quantity;

    private String size;

    private Double unitPrice;
}