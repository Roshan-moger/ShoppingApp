package com.ShoppingApp.Entity;


import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long  orderId;
    private int quantity;
    private Double amount;
    private String couponCode;
    
    @CreationTimestamp
    @Column(name = "date", updatable = false)
    private LocalDate date;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(Long id, long orderId, int quantity, Double amount, String couponCode, LocalDate date) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.quantity = quantity;
		this.amount = amount;
		this.couponCode = couponCode;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderId=" + orderId + ", quantity=" + quantity + ", amount=" + amount
				+ ", couponCode=" + couponCode + ", date=" + date + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
    
}