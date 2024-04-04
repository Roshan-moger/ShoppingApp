package com.ShoppingApp.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingApp.CouponNotFoundException.CouponNotFoundException;
import com.ShoppingApp.Entity.Coupon;
import com.ShoppingApp.Request.CouponRequest;
import com.ShoppingApp.Services.CouponService;


import java.util.Map;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    private final CouponService couponService;

   
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/fetchCoupons")
    public ResponseEntity<Map<String, Integer>> fetchCoupons() {
        try {
            Map<String, Integer> coupons = couponService.fetchCoupons();
            return ResponseEntity.ok(coupons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addCoupon(@RequestBody CouponRequest couponRequest) {
        try {
            Coupon coupon = new Coupon();
            coupon.setCodes(couponRequest.getCodes());
            coupon.setDiscount(couponRequest.getDiscount());

            couponService.addCoupon(coupon);

            return ResponseEntity.status(HttpStatus.CREATED).body("Coupon added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add coupon");
        }
    }
    @DeleteMapping("/{couponCode}")
    public ResponseEntity<?> deleteCoupon(@PathVariable
    		String couponCode) {
        couponService.deleteByCode(couponCode);
		return ResponseEntity.status(HttpStatus.OK).body("Coupon deleted successfully");
    }


}
