package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.dao.entity.Rating;
import com.example.online_shopping.dao.entity.User;
import com.example.online_shopping.dao.repository.ProductRepository;
import com.example.online_shopping.dao.repository.RatingRepository;
import com.example.online_shopping.exceptions.NotFoundException;
import com.example.online_shopping.exceptions.WrongRatingValueException;
import com.example.online_shopping.helper.ProductHelper;
import com.example.online_shopping.helper.UserHelper;

@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepository;
	@Autowired
	private UserHelper userHelper;
	@Autowired
	private ProductHelper productHelper;
	@Autowired
	private ProductRepository productRepository;

	public Rating addRatingToProduct(Long productId, Long userId, Integer ratingValue) {
		User user = userHelper.getUserById(userId);
		Product product = productHelper.getProductById(productId);
		if (ratingValue < 1 && ratingValue > 5) {
			throw new WrongRatingValueException("Rating value must be between 1 and 5");

		}
		Optional<Rating> existingRating = ratingRepository.findByProductAndUser(product, user);
		Rating rating;
		if (existingRating.isPresent()) {
			rating = existingRating.get();
			rating.setRatingValue(ratingValue.doubleValue());
		} else {
			rating = new Rating();
			rating.setProduct(product);
			rating.setUser(user);
			rating.setRatingValue(ratingValue.doubleValue());
			product.getRatings().add(rating);
		}
		Rating savedRating = ratingRepository.save(rating);
		getProductAverageRating(productId);
		productRepository.save(product);
		return savedRating;
	}

	public void getProductAverageRating(Long productId) {
		Product product = productHelper.getProductById(productId);
		List<Rating> ratings = product.getRatings();
		Double sum = 0.0;
		if (ratings.isEmpty()) {
			product.setRating(sum);
		} else {
			for (Rating rating : ratings) {
				sum += rating.getRatingValue();
			}
			product.setRating(sum / ratings.size());
		}
	}

	public void deleteRatingFromProduct(Long ratingId) {
		Rating rating = ratingRepository.findById(ratingId)
				.orElseThrow(() -> new NotFoundException("Rating not found"));
		Product product = rating.getProduct();
		product.getRatings().remove(rating);
		ratingRepository.delete(rating);
		getProductAverageRating(product.getId());
		productRepository.save(product);
	}

}
