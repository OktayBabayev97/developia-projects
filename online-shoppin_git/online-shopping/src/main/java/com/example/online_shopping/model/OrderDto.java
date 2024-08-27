package com.example.online_shopping.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.online_shopping.constants.OrderStatus;
import com.example.online_shopping.dao.entity.Product;

@Component
public class OrderDto {
	private Long id;
	private OrderStatus status;
	private Double totalAmount;
	private List<Product> products;
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
