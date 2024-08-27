package com.example.online_shopping.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_shopping.dao.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket,Long>{
	Optional<Basket> findTop1ByUserIdOrderByIdDesc(Long userId);

	Basket findByUserId(Long userId);
}
