package com.example.online_shopping.model;

import org.springframework.stereotype.Component;

@Component
public class RatingDto {
	private Long productId;
	private Long userId;
	private Double ratingValue;

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

	public Double getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(Double ratingValue) {
		this.ratingValue = ratingValue;
	}

}
