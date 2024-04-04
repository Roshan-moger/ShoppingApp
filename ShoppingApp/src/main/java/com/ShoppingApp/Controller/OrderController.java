package com.ShoppingApp.Controller;


import com.ShoppingApp.Entity.Orders;
import com.ShoppingApp.Request.PaymentResponse;
import com.ShoppingApp.Request.PaymentStatus;
import com.ShoppingApp.Services.OrderService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
	private long userId =1;
	private long orderId=100;
  
    
 


	public OrderController(OrderService orderService) {
	
		this.orderService = orderService;
		
	}


	@PostMapping("/{userId}/order")
    public ResponseEntity<?> createOrder(@PathVariable Long userId,
    		@RequestParam  int qyt, @RequestParam String coupon
                                         ) {
        // Call the OrderService to create the order
        try {
            Orders order = orderService.createOrder(userId, orderId,qyt, 
                                                   coupon 
                                                    );
            return ResponseEntity.ok(order);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping("/{userId}/orders")
    public ResponseEntity<?> getUserOrders(@PathVariable Long userId) {
        // Call the OrderService to get user orders
        try {
            return ResponseEntity.ok(orderService.getUserOrders(userId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
        try {
            return ResponseEntity.ok(orderService.getAllOrders());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve orders");
        }
    }


    @PostMapping("/{userId}/{orderId}/pay")
    public ResponseEntity<?> payOrder(@PathVariable Long userId,
                                      @PathVariable Long orderId,
                                      @RequestParam Double amount
                                     
                                      
                                     ) {
        try {
            String transactionId;
            transactionId = generateTransactionId();
			PaymentStatus paymentStatus = orderService.payOrder(userId, orderId, transactionId);
            
            if (paymentStatus == PaymentStatus.SUCCESSFUL) {
                return ResponseEntity.ok(createSuccessResponse(transactionId));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createFailureResponse(paymentStatus, transactionId));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process payment");
        }
    }

    private String generateTransactionId() {
        Random random = new Random();
        int transactionNumber = random.nextInt(1,7);
        return "tran" + "01010000" + transactionNumber;
    }

    private Object createSuccessResponse(String transactionId) {
        return new PaymentResponse(userId,orderId,transactionId, "successful", "Payment Succesfully Done");
    }

    private Object createFailureResponse(PaymentStatus paymentStatus, String transactionId) {
        switch (paymentStatus) {
            case AMOUNT_INVALID:
                return new PaymentResponse(userId,orderId,transactionId, "failed", "Payment Failed as amount is invalid");
            case BANK_FAILED:
                return new PaymentResponse(userId,orderId,transactionId, "failed", "Payment Failed from bank");
            case ORDER_INVALID:
                return new PaymentResponse(userId,orderId,transactionId, "failed", "Payment Failed due to invalid order id");
            case  PAYMENT_SERVER_UNREACHABLE:
                return new PaymentResponse(userId,orderId,transactionId, "failed", "No response from payment server");
            case ORDER_ALREADY_PAID:
                return new PaymentResponse(userId,orderId,transactionId, "failed", "Order is already paid for");
            default:
                return new PaymentResponse(userId,orderId,transactionId, "failed", "Unknown payment failure");
        }
    }
    
    
    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long userId, @PathVariable long orderId) {
        try {
            List<Orders> order = orderService.getOrderByOrderId(orderId);
           String  transactionId = generateTransactionId();

           Random random = new Random();
           int number = random.nextInt(2);
			
            if (order != null) {
                 
                
                if (transactionId != null) {
                    Map<String, Object> orderDetails = new LinkedHashMap<>();
                    orderDetails.put("orderId", order.get(number).getOrderId());
                    orderDetails.put("amount", order.get(number).getAmount());
                    orderDetails.put("date", order.get(number).getDate());
                    orderDetails.put("coupon", order.get(number).getCouponCode());
                    orderDetails.put("transactionId",transactionId);
                    if(transactionId.equals("tran010100001")) {
                    	orderDetails.put("status" ,"Success");
                    }
                    else {
                    orderDetails.put("status" ,"Failed");
                    }
                    return ResponseEntity.ok(orderDetails);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("orderId", orderId, "description", "Transaction details not found for order"));
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("orderId", orderId, "description", "Order not found"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Order not found");
        }
    }

}

