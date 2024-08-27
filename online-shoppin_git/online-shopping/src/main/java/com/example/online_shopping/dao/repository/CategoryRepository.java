package com.example.online_shopping.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_shopping.dao.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findCategoryById(Long id);
}
