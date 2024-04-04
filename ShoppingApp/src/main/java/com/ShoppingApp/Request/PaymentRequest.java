package com.ShoppingApp.Request;

public class PaymentRequest {
		private double amount;

		public PaymentRequest() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PaymentRequest(double amount) {
			super();
			this.amount = amount;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "PaymentRequest [amount=" + amount + "]";
		}
		
}
