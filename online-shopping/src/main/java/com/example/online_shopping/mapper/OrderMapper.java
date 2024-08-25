package com.example.online_shopping.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.online_shopping.dao.entity.Order;
import com.example.online_shopping.model.OrderDto;

@Component
public class OrderMapper {

	public OrderDto entityToDto(Order order) {
		OrderDto orderDto = new OrderDto();
		orderDto.setId(order.getId());
		orderDto.setProducts(order.getProducts());
		orderDto.setStatus(order.getOrderStatus());
		orderDto.setUserId(order.getUser().getId());
		orderDto.setTotalAmount(order.getTotalPrice());
		return orderDto;
	}

	public Order dtoToEntity(OrderDto orderDto) {
		Order order = new Order();
		order.setId(orderDto.getId());
		order.setProducts(orderDto.getProducts());
		order.setOrderStatus(orderDto.getStatus());
		order.getUser().setId(orderDto.getId());
		order.setTotalPrice(orderDto.getTotalAmount());
		return order;
	}

	public List<Order> dtoListToEntityList(List<OrderDto> orderDtos) {
		List<Order> orders = new ArrayList<>();
		for (OrderDto orderDto : orderDtos) {
			orders.add(dtoToEntity(orderDto));
		}
		return orders;
	}

	public List<OrderDto> entityListToDtoList(List<Order> orders) {
		List<OrderDto> orderDtos = new ArrayList<>();
		for (Order order : orders) {
			orderDtos.add(entityToDto(order));
		}
		return orderDtos;
	}
}
