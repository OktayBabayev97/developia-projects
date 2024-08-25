package com.example.online_shopping.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.dao.entity.Comment;
import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.dao.entity.User;
import com.example.online_shopping.dao.repository.CommentRepository;
import com.example.online_shopping.dao.repository.ProductRepository;
import com.example.online_shopping.exceptions.NotFoundException;
import com.example.online_shopping.helper.ProductHelper;
import com.example.online_shopping.helper.UserHelper;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private UserHelper userHelper;
	@Autowired
	private ProductHelper productHelper;
	@Autowired
	private ProductRepository productRepository;

	public Comment addCommentToProduct(Long productId, Long userId, String text) {
		User user = userHelper.getUserById(userId);
		Product product = productHelper.getProductById(productId);
		Comment comment = new Comment();
		comment.setText(text);
		comment.setProduct(product);
		comment.setUser(user);
		comment.setCreatedAtTime(LocalDateTime.now());
		product.getComments().add(comment);
		productRepository.save(product);
		return comment;
	}

	public Comment updateComment(Long commentId, String text) {
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new NotFoundException("Comment not founded"));
		comment.setText(text);
		return commentRepository.save(comment);

	}

	public List<Comment> getCommentsByProduct(Long productId) {
		Product product = productHelper.getProductById(productId);
		return commentRepository.findAllByProductId(product.getId());
	}

	public void deleteById(Long commentId) {
		commentRepository.deleteById(commentId);
	}
}
