package com.example.online_shopping.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_shopping.dao.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findById(Long id);

	List<Product> findProductsByIdIn(List<Long> productId);

	List<Product> findAllByPriceBetween(Double minPrice, Double maxPrice);
}
