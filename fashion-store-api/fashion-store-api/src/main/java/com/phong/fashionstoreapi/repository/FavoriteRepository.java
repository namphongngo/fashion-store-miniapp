package com.phong.fashionstoreapi.repository;

import com.phong.fashionstoreapi.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
