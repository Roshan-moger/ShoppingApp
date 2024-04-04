package com.ShoppingApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingApp.Entity.Inventory;
import com.ShoppingApp.Repository.InventoryRepository;
import com.ShoppingApp.Services.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public Inventory getInventory() {
        return inventoryRepository.findById(1L).orElse(null);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItems(@RequestBody Inventory inventoryData) {
        Inventory inventory = inventoryService.addItems(inventoryData);
        return ResponseEntity.ok(inventory);
    }
    @GetMapping("/ordered")
    public Inventory orderItems(@RequestParam int quantity) {
        Inventory inventory = inventoryRepository.findById(1L).orElse(null);
        if (inventory != null && quantity <= inventory.getAvailable()) {
            inventory.setOrdered(quantity);
            inventory.setAvailable(inventory.getAvailable() - quantity);
            inventoryRepository.save(inventory);
        }
       
        return inventory;
    }
}