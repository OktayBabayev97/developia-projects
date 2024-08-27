package com.example.online_shopping.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.online_shopping.dao.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon,Long>{
Optional<Coupon> findByCode(String code);
}
