package com.ShoppingApp.Request;

public class OrderRequest {
	
    private Long userId;
    private int orderId;
    private int quantity;
    private String couponCode;
	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderRequest(Long userId, int orderId, int quantity, String couponCode) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.quantity = quantity;
		this.couponCode = couponCode;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	@Override
	public String toString() {
		return "OrderRequest [userId=" + userId + ", orderId=" + orderId + ", quantity=" + quantity + ", couponCode="
				+ couponCode + "]";
	}
    
    

}
