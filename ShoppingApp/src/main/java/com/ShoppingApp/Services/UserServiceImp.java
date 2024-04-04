package com.ShoppingApp.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingApp.Entity.User;
import com.ShoppingApp.Repository.UserRepository;
@Service
public class UserServiceImp  implements UserService{
	
	@Autowired
	private  UserRepository userRepository ;

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long userId, User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	 @Override
	    public boolean deleteUser(Long userId) {
	        if (userRepository.existsById(userId)) {
	            userRepository.deleteById(userId);
	            return true;
	        } else {
	            return false; // User with the given ID does not exist
	        }
	    }

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
