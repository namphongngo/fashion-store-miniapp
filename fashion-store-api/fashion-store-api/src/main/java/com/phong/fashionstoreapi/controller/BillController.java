package com.phong.fashionstoreapi.controller;

import com.phong.fashionstoreapi.dto.CartItemRequest;
import com.phong.fashionstoreapi.dto.CheckoutRequest;

import com.phong.fashionstoreapi.entity.Bill;
import com.phong.fashionstoreapi.entity.BillDetail;
import com.phong.fashionstoreapi.entity.Product;

import com.phong.fashionstoreapi.repository.BillDetailRepository;
import com.phong.fashionstoreapi.repository.BillRepository;
import com.phong.fashionstoreapi.repository.ProductRepository;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class BillController {

    private final BillRepository billRepository;

    private final BillDetailRepository billDetailRepository;

    private final ProductRepository productRepository;

    public BillController(

            BillRepository billRepository,

            BillDetailRepository billDetailRepository,

            ProductRepository productRepository

    ) {

        this.billRepository =
                billRepository;

        this.billDetailRepository =
                billDetailRepository;

        this.productRepository =
                productRepository;
    }

    @PostMapping("/api/checkout")
    public Bill checkout(

            @RequestBody CheckoutRequest request

    ) {

        Bill bill = new Bill();

        bill.setCustomerName(
                request.getCustomerName()
        );

        bill.setPhone(
                request.getPhone()
        );

        bill.setAddress(
                request.getAddress()
        );

        bill.setTotalAmount(
                request.getTotalAmount()
        );

        bill.setStatus(
                "PENDING"
        );

        bill.setCreatedAt(
                LocalDateTime.now()
        );

        Bill savedBill =
                billRepository.save(bill);

        for (CartItemRequest item : request.getItems()) {

            Optional<Product> optionalProduct =
                    productRepository.findById(
                            item.getProductId()
                    );

            if (optionalProduct.isPresent()) {

                Product product =
                        optionalProduct.get();

                BillDetail detail =
                        new BillDetail();

                detail.setBill(
                        savedBill
                );

                detail.setProduct(
                        product
                );

                detail.setQuantity(
                        item.getQuantity()
                );

                detail.setSize(
                        item.getSize()
                );

                detail.setUnitPrice(
                        item.getUnitPrice()
                );

                billDetailRepository.save(detail);
            }
        }

        return savedBill;
    }

    @GetMapping("/api/bills")
    public List<Bill> getAllBills() {

        return billRepository.findAll();
    }

    @GetMapping("/api/bills/{id}")
    public Bill getBillById(

            @PathVariable Long id

    ) {

        return billRepository
                .findById(id)
                .orElse(null);
    }
}