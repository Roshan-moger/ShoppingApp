package com.ShoppingApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingApp.Entity.Inventory;
import com.ShoppingApp.Repository.InventoryRepository;

@Service
public class InventoryServiceImp  implements InventoryService{
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public Inventory addItems(Inventory inventoryData) {
		// TODO Auto-generated method stub
		return inventoryRepository.save(inventoryData);
	}
	

}
