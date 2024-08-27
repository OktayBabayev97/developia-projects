package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.dao.entity.Category;
import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.dao.repository.CategoryRepository;
import com.example.online_shopping.exceptions.NotFoundException;
import com.example.online_shopping.helper.ProductHelper;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductHelper productHelper;

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(Long id) {
		return categoryRepository.findCategoryById(id).get();
	}

//	public Category getProductsByCategory(Long categoryId) {
//		Optional<Category> category = categoryRepository.findCategoryById(categoryId);
//		if (category.isEmpty()) {
//			throw new NotFoundException("Category not found");
//		}
//		return categoryRepository.findCategoryById(categoryId).get();
//	}

	public Category addProductToCategory(Long productId, Long categoryId) {
		Product product = productHelper.getProductById(productId);
		Optional<Category> category = categoryRepository.findCategoryById(categoryId);
		if (category.isEmpty()) {
			throw new NotFoundException("Category not found");
		}
		category.get().getProducts().add(product);
		// product.getCategory().setName(category.get().getName());
		product.setCategory(category.get());
		categoryRepository.save(category.get());
		return category.get();
	}

	public Category updateCategory(Long categoryId, Category category) {
		Optional<Category> updatedCategory = categoryRepository.findCategoryById(categoryId);
		if (updatedCategory.isEmpty()) {
			throw new NotFoundException("Category not found");
		}
		updatedCategory.get().setName(category.getName());
		updatedCategory.get().setProducts(category.getProducts());
		categoryRepository.save(updatedCategory.get());
		return updatedCategory.get();
	}

	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}
}
