package com.ShoppingApp.Services;

import java.util.List;

import com.ShoppingApp.Entity.User;

public interface UserService {

	User getUserById(Long userId);

	User createUser(User user);

	User updateUser(Long userId, User user);

	boolean deleteUser(Long userId);

	List<User> getAllUsers();

	
		// TODO Auto-generated method st

}
