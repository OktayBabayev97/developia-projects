package com.example.online_shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.online_shopping.dao.entity.Basket;
import com.example.online_shopping.model.BasketDto;
import com.example.online_shopping.service.BasketService;

@RestController
@RequestMapping("/api/basket")
public class BasketController {
	@Autowired
	private BasketService basketService;

	@GetMapping("/{userId}")
	public BasketDto getBasketById(@PathVariable("userId") Long userId) {
		return basketService.findByUserId(userId);
	}

	@PutMapping("/{userId}")
	public Basket addProductToBasket(@PathVariable("userId") Long userId, @RequestBody List<Long> productIds) {
		return basketService.addProductToBasket(userId, productIds);
	}
}
