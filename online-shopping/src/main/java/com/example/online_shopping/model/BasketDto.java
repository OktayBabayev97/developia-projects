package com.example.online_shopping.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.online_shopping.dao.entity.Product;

@Component
public class BasketDto {
	private Long id;
	private List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
