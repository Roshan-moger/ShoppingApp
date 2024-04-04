package com.ShoppingApp.Services;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.ShoppingApp.Entity.Orders;
import com.ShoppingApp.Repository.OrderRepository;
import com.ShoppingApp.Request.PaymentStatus;

@Service
public class OrderServiceImp  implements OrderService{

	 private final OrderRepository orderRepository;
	  
	    private final CouponService couponService;

	   
	   

	    public OrderServiceImp(OrderRepository orderRepository, CouponService couponService) {
			
			this.orderRepository = orderRepository;
			
			this.couponService = couponService;
		}



		@Override
	    public Orders createOrder(Long userId, long orderId, int quantity, String couponCode) {
	        // Check if the quantity is valid
	        if (quantity <= 0) {
	            throw new IllegalArgumentException("Invalid quantity");
	        }

	        // Fetch the product price (assuming product service is available)
	        double productPrice = 100; // Assuming orderId represents product price

	        // Check and apply the coupon if it's valid
	        double discount = 0.0;
	        if (couponCode != null && !couponCode.isEmpty()) {
	            try {
	                discount = couponService.applyCoupon(userId, couponCode);
	            } catch (Exception e) {
	                throw new IllegalArgumentException(e.getMessage());
	            }
	        }

	        // Calculate the order amount after applying discount
	        double totalAmount = productPrice * quantity * (1 - discount / 100);
	        // Create the order
	        Orders order = new Orders();
	        order.setId(userId); // This is incorrect, order ID should be generated automatically by the database
	        order.setOrderId(orderId);
	        order.setQuantity(quantity);
	        order.setAmount(totalAmount);
	        order.setCouponCode(couponCode);

	        LocalDate currentDate = LocalDate.now();
	        order.setDate(currentDate);
	        couponService.deleteByCode(couponCode);
	        return orderRepository.save(order);
	    }



		@Override
		public List<Orders> getUserOrders(Long id) {
		    // Retrieve the order for the given user ID from the database
		    Optional<Orders> userOrderOptional = orderRepository.findById(id);
		    
		    // Check if an order was found
		    if (userOrderOptional.isPresent()) {
		        // If an order is found, return a list containing only that order
		        return Collections.singletonList(userOrderOptional.get());
		    } else {
		        // If no order is found, throw an IllegalArgumentException
		        throw new IllegalArgumentException("No orders found for user ID: " + id);
		    }
		}



		@Override
		public Orders getOrderById(Long orderId) {
			// TODO Auto-generated method stub
			return orderRepository.getReferenceById(orderId);
		}



		@Override
		public List<Orders> getAllOrders() {
			// TODO Auto-generated method stub
			return orderRepository.findAll();
		}



		@Override
		public PaymentStatus payOrder(Long userId, Long orderId, String transactionId) {
			if(transactionId.equals("tran010100001" )) {
				return PaymentStatus.SUCCESSFUL;
			}
			else if (transactionId.equals("tran010100002" )) {
				return PaymentStatus.AMOUNT_INVALID;
				
			}
			else if (transactionId.equals("tran010100003" )) {
				return PaymentStatus.BANK_FAILED;
				
			}
			else if (transactionId.equals("tran010100004" )) {
				return PaymentStatus.ORDER_INVALID;
	
}
			else if (transactionId.equals("tran010100005" )) {
				return PaymentStatus.PAYMENT_SERVER_UNREACHABLE;
	
}
			else  {
				return PaymentStatus.ORDER_ALREADY_PAID;
	
}
			
		}



		@Override
		public List<Orders>  getOrderByOrderId(long orderId) {
			// TODO Auto-generated method stub
			return orderRepository.findByOrderId(orderId);
		}



		


		

}
