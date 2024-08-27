package com.example.online_shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.online_shopping.dao.entity.Comment;
import com.example.online_shopping.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	@Autowired
	private CommentService commentService;

	@GetMapping("/{id}")
	public List<Comment> getCommentsById(@PathVariable("id") Long id) {
		return commentService.getCommentsByProduct(id);
	}

	@PostMapping("/add-comment")
	public Comment createComment(@RequestParam("text") String text, @RequestParam("productId") Long productId,
			@RequestParam("userId") Long userId) {
		return commentService.addCommentToProduct(productId, userId, text);
	}

	@PutMapping("/edit-comment/{id}")
	public Comment updateComment(@PathVariable("id") Long commentId, @RequestParam("text") String text) {
		return commentService.updateComment(commentId, text);
	}

	@DeleteMapping("/{id}")
	public void deleteComment(@PathVariable("id") Long id) {
		commentService.deleteById(id);
	}
}
