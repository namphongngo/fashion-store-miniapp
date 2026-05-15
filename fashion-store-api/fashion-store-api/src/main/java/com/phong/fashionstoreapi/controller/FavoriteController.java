package com.phong.fashionstoreapi.controller;

import com.phong.fashionstoreapi.entity.Favorite;
import com.phong.fashionstoreapi.entity.Product;
import com.phong.fashionstoreapi.repository.FavoriteRepository;
import com.phong.fashionstoreapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin("*")
public class FavoriteController {

    private final FavoriteRepository favoriteRepository;

    private final ProductRepository productRepository;

    public FavoriteController(

            FavoriteRepository favoriteRepository,

            ProductRepository productRepository

    ) {

        this.favoriteRepository =
                favoriteRepository;

        this.productRepository =
                productRepository;
    }

    @PostMapping("/{productId}")
    public Favorite addFavorite(

            @PathVariable Long productId

    ) {

        Product product =
                productRepository
                        .findById(productId)
                        .orElse(null);

        Favorite favorite =
                new Favorite();

        favorite.setProduct(product);

        return favoriteRepository.save(favorite);
    }

    @GetMapping
    public List<Favorite> getFavorites() {

        return favoriteRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteFavorite(

            @PathVariable Long id

    ) {

        favoriteRepository.deleteById(id);
    }
}