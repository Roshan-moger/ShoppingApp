package com.ShoppingApp.Repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ShoppingApp.Entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {



	  @Query("SELECT c.codes, c.discount FROM Coupon c")
	    Map<String, Integer> findAllCoupons();

	Coupon findByCodes(String codes);

	

	
	  
	  
	
}