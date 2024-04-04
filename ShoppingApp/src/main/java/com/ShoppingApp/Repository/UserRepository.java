package com.ShoppingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingApp.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
