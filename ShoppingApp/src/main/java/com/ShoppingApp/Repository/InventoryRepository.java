package com.ShoppingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShoppingApp.Entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}