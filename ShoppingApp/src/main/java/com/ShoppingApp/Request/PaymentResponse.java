package com.ShoppingApp.Request;

public class PaymentResponse {
	
	private long userId;
	private long orderId;
	private String transactionId;
    private String status;
    private String description;
	public PaymentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaymentResponse(long userId, long orderId, String transactionId, String status, String description) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.transactionId = transactionId;
		this.status = status;
		this.description = description;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PaymentResponse [userId=" + userId + ", orderId=" + orderId + ", transactionId=" + transactionId
				+ ", status=" + status + ", description=" + description + "]";
	}

	 

}
