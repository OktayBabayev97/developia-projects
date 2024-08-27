package com.example.online_shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_shopping.dao.entity.Coupon;
import com.example.online_shopping.service.CouponService;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
	@Autowired
	private CouponService couponService;

	@PostMapping
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponService.createCoupon(coupon);
	}
}
