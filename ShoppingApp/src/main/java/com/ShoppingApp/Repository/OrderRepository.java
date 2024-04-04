package com.ShoppingApp.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingApp.Entity.Orders;
import java.util.List;


public interface OrderRepository extends JpaRepository<Orders, Long> {

	

	List<Orders> findByOrderId(long orderId);

	
}