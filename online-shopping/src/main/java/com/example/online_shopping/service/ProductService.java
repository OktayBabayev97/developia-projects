package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.dao.entity.Category;
import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.dao.repository.CategoryRepository;
import com.example.online_shopping.dao.repository.ProductRepository;
import com.example.online_shopping.exceptions.NotFoundException;
import com.example.online_shopping.helper.ProductHelper;
import com.example.online_shopping.mapper.ProductMapper;
import com.example.online_shopping.model.ProductDto;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductHelper productHelper;
	@Autowired
	private CategoryRepository categoryRepository;

	public Product createProduct(ProductDto productDto) {
		Product product = productMapper.dtoToEntity(productDto);
		return productRepository.save(product);
	}

	public ProductDto updateProduct(Long productId, ProductDto productDto) {
		Product product = productHelper.getProductById(productId);
		ProductDto updatedProduct = productMapper.entityToDto(product);
		updatedProduct.setName(productDto.getName());
		updatedProduct.setPrice(productDto.getPrice());
		updatedProduct.setDescription(product.getDescription());
		product = productMapper.dtoToEntity(updatedProduct);
		productRepository.save(product);
		return updatedProduct;
	}

	public Product getProductById(Long productId) {
		Product product = productHelper.getProductById(productId);
		return product;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> getProductsByCategory(Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if (category.isEmpty()) {
			throw new NotFoundException("Category not found");
		}
		return category.get().getProducts();
	}

	public List<Product> getProductsByPriceBetween(Double minPrice, Double maxPrice) {
		return productRepository.findAllByPriceBetween(minPrice, maxPrice);
	}

	public void deleteProduct(Long productId) {
		Product product = productHelper.getProductById(productId);
		productRepository.deleteById(product.getId());
	}
}
