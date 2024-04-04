package com.ShoppingApp.Services;

import java.util.List;

import com.ShoppingApp.Entity.Orders;
import com.ShoppingApp.Request.PaymentStatus;

public interface OrderService {

	Orders createOrder(Long userId,long orderId, int quantity, String couponCode);

	PaymentStatus payOrder(Long userId, Long orderId, String transactionId);

	Object getUserOrders(Long userId);

	Orders getOrderById(Long orderId);

	List<Orders> getAllOrders();

	List<Orders>  getOrderByOrderId(long orderId);

	
}
