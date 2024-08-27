package com.example.online_shopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_shopping.dao.entity.Coupon;
import com.example.online_shopping.dao.repository.CouponRepository;
import com.example.online_shopping.exceptions.NotFoundException;

@Service
public class CouponService {
	 @Autowired
	    private CouponRepository couponRepository;

	    public Coupon createCoupon(Coupon coupon) {
	        return couponRepository.save(coupon);
	    }
	    
	    public Double applyCoupon(String code, Double totalAmount) {
	        Optional<Coupon> coupon = couponRepository.findByCode(code);
	        if(coupon.isEmpty()) {
	            throw new NotFoundException("Invalid coupon code");

	        }
	        return totalAmount * ((100 - coupon.get().getDiscountPercentage()) / 100);
	    }
}
