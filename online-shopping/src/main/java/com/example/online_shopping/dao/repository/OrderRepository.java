package com.example.online_shopping.dao.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_shopping.constants.OrderStatus;
import com.example.online_shopping.dao.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByUserId(Long userId);

	List<Order> findAllByUserIdAndCreatedDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);

	Optional<Order> findByUserIdAndId(Long userId, Long id);

	Optional<Order> findByUserIdAndStatus(Long userId, OrderStatus status);
}
