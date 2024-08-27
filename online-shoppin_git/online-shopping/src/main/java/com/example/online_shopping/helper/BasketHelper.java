package com.example.online_shopping.helper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.online_shopping.constants.ExceptionMessages;
import com.example.online_shopping.dao.entity.Basket;
import com.example.online_shopping.dao.repository.BasketRepository;
import com.example.online_shopping.exceptions.NotFoundException;

@Component
public class BasketHelper {
@Autowired
private BasketRepository basketRepository;

public Basket getBasket(Long userId) {
	Optional<Basket> basket=basketRepository.findTop1ByUserIdOrderByIdDesc(userId);
	if(basket.isEmpty()) {
		throw new NotFoundException(ExceptionMessages.BASKET_NOT_FOUND);
	}if(basket.get().getProducts().isEmpty()){
		throw new NotFoundException("There is no product");
	}
	return basket.get();
}
}
