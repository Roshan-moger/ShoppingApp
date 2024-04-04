package com.ShoppingApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codes;
    private int discount;
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coupon(Long id, String codes, int discount) {
		super();
		this.id = id;
		this.codes = codes;
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", codes=" + codes + ", discount=" + discount + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodes() {
		return codes;
	}
	public void setCodes(String codes) {
		this.codes = codes;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
    
	
}