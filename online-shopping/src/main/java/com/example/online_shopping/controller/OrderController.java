package com.example.online_shopping.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.online_shopping.constants.OrderStatus;
import com.example.online_shopping.dao.entity.Order;
import com.example.online_shopping.model.OrderDto;
import com.example.online_shopping.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/{userId}")
	public List<OrderDto> getAllOrders(@PathVariable("userId") Long userId) {
		return orderService.getAllOrdersByUserId(userId);
	}

	@GetMapping("/date-range")
	public List<Order> getOrdersByUserIdAndDateRange(@PathVariable Long userId, @RequestParam LocalDateTime startDate,
			@RequestParam LocalDateTime endDate) {
		return orderService.getOrdersByUserIdAndDateRange(userId, startDate, endDate);
	}

	@PostMapping("/{userId}")
	public OrderDto createOrder(@PathVariable("userId") Long userId, String couponCode) {
		return orderService.createOrder(userId, couponCode);
	}

	@PutMapping("/{orderId}/{userId}/status")
	public OrderDto updateOrderStatus(@PathVariable("orderId") Long orderId, @PathVariable("user") Long userId,
			@RequestBody OrderStatus status) {
		return orderService.updateOrderStatus(orderId, userId, status);
	}
}
