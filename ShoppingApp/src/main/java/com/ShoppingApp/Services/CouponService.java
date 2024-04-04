package com.ShoppingApp.Services;

import java.util.Map;

import com.ShoppingApp.Entity.Coupon;

public interface CouponService {

	double applyCoupon(Long userId, String couponCode);

	

	void addCoupon(Coupon coupon);



	Map<String, Integer> fetchCoupons();



	void deleteByCode(String couponCode);


	

	

}
