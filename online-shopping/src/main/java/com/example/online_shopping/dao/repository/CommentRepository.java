package com.example.online_shopping.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_shopping.dao.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findAllByProductId(Long productId);
}
