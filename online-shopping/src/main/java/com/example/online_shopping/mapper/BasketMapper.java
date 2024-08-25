package com.example.online_shopping.mapper;

import org.springframework.stereotype.Component;

import com.example.online_shopping.dao.entity.Basket;
import com.example.online_shopping.model.BasketDto;

@Component
public class BasketMapper {
public BasketDto entityToDto(Basket basket) {
	BasketDto basketDto=new BasketDto();
	basketDto.setId(basket.getId());
	basketDto.setProducts(basket.getProducts());
	return basketDto;
}
public Basket dtoToEntity(BasketDto basketDto) {
	Basket basket=new Basket();
	basket.setId(basketDto.getId());
	basket.setProducts(basketDto.getProducts());
	return basket;
}
}
