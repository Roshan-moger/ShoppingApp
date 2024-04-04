package com.ShoppingApp.Request;

public class CouponRequest {
	 private String codes;
	    private int discount;
		public CouponRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CouponRequest(String codes, int discount) {
			super();
			this.codes = codes;
			this.discount = discount;
		}
		@Override
		public String toString() {
			return "CouponRequest [codes=" + codes + ", discount=" + discount + "]";
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
