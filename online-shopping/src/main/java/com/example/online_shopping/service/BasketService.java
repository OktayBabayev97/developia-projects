package com.example.online_shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.dao.entity.Basket;
import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.dao.entity.User;
import com.example.online_shopping.dao.repository.BasketRepository;
import com.example.online_shopping.dao.repository.ProductRepository;
import com.example.online_shopping.helper.UserHelper;
import com.example.online_shopping.mapper.BasketMapper;
import com.example.online_shopping.model.BasketDto;

@Service
public class BasketService {
	@Autowired
	private BasketRepository basketRepository;
	@Autowired
	private BasketMapper basketMapper;
	@Autowired
	private UserHelper userHelper;
	@Autowired
	private ProductRepository productRepository;

	public BasketDto findByUserId(Long userId) {
		User user = userHelper.getUserById(userId);
		Optional<Basket> basket = basketRepository.findTop1ByUserIdOrderByIdDesc(userId);
		if (basket.isEmpty()) {
			Basket createdBasket = new Basket();
			createdBasket.setUser(user);
			createdBasket = basketRepository.save(createdBasket);
			return basketMapper.entityToDto(createdBasket);
		}
		return basketMapper.entityToDto(basket.get());
	}

	public Basket addProductToBasket(Long userId, List<Long> productIds) {
		List<Product> selectedProducts = productRepository.findProductsByIdIn(productIds);
		Optional<Basket> basket = basketRepository.findTop1ByUserIdOrderByIdDesc(userId);
		basket.get().setProducts(selectedProducts);
		basketRepository.save(basket.get());
		return basket.get();
	}

}
