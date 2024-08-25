package com.example.online_shopping.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.constants.OrderStatus;
import com.example.online_shopping.dao.entity.Basket;
import com.example.online_shopping.dao.entity.Order;
import com.example.online_shopping.dao.entity.Product;
import com.example.online_shopping.dao.entity.User;
import com.example.online_shopping.dao.repository.OrderRepository;
import com.example.online_shopping.exceptions.NotFoundException;
import com.example.online_shopping.helper.BasketHelper;
import com.example.online_shopping.helper.UserHelper;
import com.example.online_shopping.mapper.OrderMapper;
import com.example.online_shopping.model.OrderDto;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private UserHelper userHelper;

	@Autowired
	private BasketHelper basketHelper;
	@Autowired
	private CouponService couponService;

	public List<OrderDto> getAllOrdersByUserId(Long userId) {
		List<Order> orders = orderRepository.findByUserId(userId);
		if (orders.isEmpty())
			return new ArrayList<OrderDto>();
		return orderMapper.entityListToDtoList(orders);
	}

	public OrderDto createOrder(Long userId, String couponCode) {
		User user = userHelper.getUserById(userId);
		Basket basket = basketHelper.getBasket(userId);
		Double totalPrice = calculateTotalPrice(basket);
		if (!couponCode.isEmpty()) {
			totalPrice = couponService.applyCoupon(couponCode, totalPrice);
		}
		List<Product> selectedProducts = new ArrayList<>();
		selectedProducts.addAll(basket.getProducts());
		Order order = new Order();
		order.setUser(user);
		order.setProducts(selectedProducts);
		order.setOrderStatus(OrderStatus.PENDING);
		order.setTotalPrice(totalPrice);
		order.setCreatedAt(LocalDateTime.now());
		orderRepository.save(order);
		return orderMapper.entityToDto(order);
	}

	public OrderDto updateOrderStatus(Long orderId, Long userId, OrderStatus status) {
		Optional<Order> order = orderRepository.findByUserIdAndId(orderId, userId);
		if (order.isEmpty()) {
			throw new NotFoundException("Order not found");
		}
		order.get().setOrderStatus(status);
		orderRepository.save(order.get());
		return orderMapper.entityToDto(order.get());
	}

	public void processOrder(Long orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("Order not found"));
		if (order.getOrderStatus() == OrderStatus.PENDING) {
			order.setOrderStatus(OrderStatus.SOLD);
			orderRepository.save(order);
			shipOrder(order);
		}
	}

	private void shipOrder(Order order) {
		order.setOrderStatus(OrderStatus.SHIPPED);
		orderRepository.save(order);
		deliverOrder(order);
	}

	private void deliverOrder(Order order) {
		order.setOrderStatus(OrderStatus.DELIVERED);
		orderRepository.save(order);
	}

	private Double calculateTotalPrice(Basket basket) {
		List<Product> selectedBooks = basket.getProducts();
		Double totalPrice = Double.valueOf(0);
		for (Product book : selectedBooks) {
			totalPrice += book.getPrice();
		}
		return totalPrice;
	}

	public List<Order> getOrdersByUserIdAndDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
		return orderRepository.findAllByUserIdAndCreatedDateBetween(userId, startDate, endDate);
	}
}
