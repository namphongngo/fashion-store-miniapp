package com.phong.fashionstoreapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class CheckoutRequest {
    private String customerName;
    private String phone;
    private String address;
    private Double totalAmount;

    private List<CartItemRequest> items;
}
