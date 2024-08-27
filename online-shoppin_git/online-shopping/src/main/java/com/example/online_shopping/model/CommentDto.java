package com.example.online_shopping.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class CommentDto {
	private Long productId;
	private Long userId;
	private String text;
	private LocalDateTime createdAtTime;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreatedAtTime() {
		return createdAtTime;
	}

	public void setCreatedAtTime(LocalDateTime createdAtTime) {
		this.createdAtTime = createdAtTime;
	}

}
