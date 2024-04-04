package com.ShoppingApp.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ShoppingApp.Entity.Coupon;
import com.ShoppingApp.Repository.CouponRepository;

@Service
public class CouponServiceImp implements CouponService {

	private  CouponRepository couponRepository;
	
	public CouponServiceImp(CouponRepository couponRepository) {
		
		this.couponRepository = couponRepository;
	}



	
	

    @Override
    public double applyCoupon(Long userId, String couponCode) {
        Coupon coupon = couponRepository.findByCodes(couponCode);
        // Assuming you have logic here to apply the coupon to the user's order and calculate the discount
        // For example, you might fetch the coupon discount percentage and apply it to the order amount
        // You can replace this with your actual logic
        if (coupon != null) {
            return coupon.getDiscount();
        } else {
            throw new IllegalArgumentException("Invalid coupon code");
        }
    }



    @Override
    public void addCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }



	@Override
		public Map<String, Integer> fetchCoupons() {
	        List<Coupon> coupons = couponRepository.findAll();
	        Map<String, Integer> couponMap = new HashMap<>();
	        for (Coupon coupon : coupons) {
	            couponMap.put(coupon.getCodes(), coupon.getDiscount());
	        }
	        return couponMap;
	    }






	@Override
	public void deleteByCode(String couponCode) {
		 Coupon optionalCoupon = couponRepository.findByCodes(couponCode);
		 
	            couponRepository.delete(optionalCoupon);
	        
		
	}
	}


	

  
	

