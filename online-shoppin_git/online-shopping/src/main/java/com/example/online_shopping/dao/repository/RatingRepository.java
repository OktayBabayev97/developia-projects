package com.example.online_shopping.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.dao.entity.Rating;
import com.example.online_shopping.dao.entity.User;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	Optional<Rating> findByProductAndUser(Product product, User user);
}
