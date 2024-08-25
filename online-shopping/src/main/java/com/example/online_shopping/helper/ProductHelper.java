package com.example.online_shopping.helper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.dao.repository.ProductRepository;
import com.example.online_shopping.exceptions.NotFoundException;

@Component
public class ProductHelper {
	@Autowired
	private ProductRepository productRepository;

	public Product getProductById(Long productId) {
		Optional<Product> product = productRepository.findById(productId);
		if (product.isEmpty()) {
			throw new NotFoundException("Product not found");
		}
		return product.get();
	}
}
