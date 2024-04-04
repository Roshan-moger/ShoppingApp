package com.ShoppingApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ordered;
    private int price;
    private int available;
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(Long id, int ordered, int price, int available) {
		super();
		this.id = id;
		this.ordered = ordered;
		this.price = price;
		this.available = available;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getOrdered() {
		return ordered;
	}
	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", ordered=" + ordered + ", price=" + price + ", available=" + available + "]";
	}

  
}