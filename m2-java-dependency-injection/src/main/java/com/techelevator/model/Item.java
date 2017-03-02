package com.techelevator.model;

import com.techelevator.DollarAmount;

public class Item {
	private String slot;
	private String name;
	private int stock = 5;
	private DollarAmount price;
	
	public String getSlot() {
		return slot;
	}
	
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public DollarAmount getPrice() {
		return price;
	}
	
	public void setPrice(DollarAmount price) {
		this.price = price;
	}
}
