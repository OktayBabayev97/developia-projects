package com.example.online_shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.online_shopping.dao.entity.Rating;
import com.example.online_shopping.service.RatingService;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;

	@PostMapping("/rate")
	public Rating addRatingToProduct(@RequestParam("productId") Long productId, @RequestParam("userId") Long userId,
			@RequestParam("ratingValue") Integer ratingValue) {
		return ratingService.addRatingToProduct(productId, userId, ratingValue);
	}

	@DeleteMapping("/{id}")
	public void deleteRatingFromProduct(@PathVariable("id") Long ratingId) {
		ratingService.deleteRatingFromProduct(ratingId);
	}
}
