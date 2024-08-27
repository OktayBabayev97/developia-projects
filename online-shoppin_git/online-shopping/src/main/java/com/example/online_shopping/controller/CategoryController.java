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
import com.example.online_shopping.dao.entity.Category;
import com.example.online_shopping.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Category> getAllCategories() {
		return categoryService.findAll();
	}

	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable("id") Long id) {
		return categoryService.getCategoryById(id);
	}

	@PutMapping("addproduct/{id}")
	public Category addProductToCategory(@RequestParam("productId") Long productId, @PathVariable("id") Long categoryId) {
		return categoryService.addProductToCategory(productId, categoryId);
	}

	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	@PutMapping("edit/{id}")
	public Category updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteCategoryById(id);
	}
}
