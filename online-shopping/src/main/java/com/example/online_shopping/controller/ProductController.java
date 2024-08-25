package com.example.online_shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.model.ProductDto;
import com.example.online_shopping.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}

	@GetMapping("/category/{id}")
	public List<Product> getProductByCategory(@PathVariable("id") Long categoryId) {
		return productService.getProductsByCategory(categoryId);
	}

	@GetMapping("/price-range")
	public List<Product> getProductsByPriceBetween(@RequestParam Double minPrice,@RequestParam Double maxPrice){
		return productService.getProductsByPriceBetween(minPrice, maxPrice);
	}
	@PostMapping
	public Product createProduct(@RequestBody ProductDto productDto) {
		return productService.createProduct(productDto);
	}

	@PutMapping("/edit/{id}")
	public ProductDto updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
		return productService.updateProduct(id, productDto);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
	}

}
