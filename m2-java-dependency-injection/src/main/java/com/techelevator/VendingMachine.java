package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.techelevator.model.Item;
import com.techelevator.model.ItemLoader;

@Component
public class VendingMachine {
	private DollarAmount balance = DollarAmount.ZERO_DOLLARS;
	private Map<String, Item> inventory;
	private TransactionLogger logger;
	
	@Autowired
	public VendingMachine(TransactionLogger logger) {
		inventory = new HashMap<>();
		this.logger = logger;
	}
	
	@Autowired
	@Qualifier("Database")
	public void setItemLoader(ItemLoader loader) {
		List<Item> items = loader.loadItems();
		for(Item item : items) {
			inventory.put(item.getSlot(), item);
		}
	}
	
	public void printInventory() {
		List<String> slots = new ArrayList<>(inventory.keySet());
		Collections.sort(slots);
		
		System.out.println("Slot Description\tPrice Stock");
		System.out.println("-----------------------------------");
		
		for(String slot : slots) {
			Item item = inventory.get(slot);
			String tabs = getTabsForName(item.getName());
			String stock = item.getStock() == 0 ? "SOLD OUT" : Integer.toString(item.getStock());
			System.out.println(String.format("%s   %s" + tabs + "%s  (%s)", item.getSlot(), item.getName(), item.getPrice(), stock));
		}
	}
	
	public void vendProduct(String slot) {
		if(!inventory.containsKey(slot.toUpperCase())) {
			System.out.println("\n" + slot + " is an invalid selection, please try again.");
			return;
		}
		
		Item item = inventory.get(slot.toUpperCase());
		if(item.getStock() == 0) {
			System.out.println("\nSorry, but we're all out of " + item.getName());
			return;
		}
		
		if(balance.isLessThan(item.getPrice())) {
			System.out.println("\nPlease insert more money to purchase this item.");
			return;
		}
		
		logger.logVendProduct(item);
		item.setStock(item.getStock() - 1);
		balance = balance.minus(item.getPrice());
		System.out.println("\nEnjoy your delicious " + item.getName());
	}
	
	public DollarAmount cashOut() {
		logger.logCashOut(balance);
		DollarAmount change = balance;
		balance = DollarAmount.ZERO_DOLLARS;
		return change;
	}

	public DollarAmount getBalance() {
		return balance;
	}
	
	public void addMoney(DollarAmount money) {
		logger.logMoneyFeed(money);
		balance = balance.plus(money);
	}
	
	private String getTabsForName(String name) {
		if(name.length() >= 11) { return "\t"; }
		else { return "\t\t"; }
	}
}
