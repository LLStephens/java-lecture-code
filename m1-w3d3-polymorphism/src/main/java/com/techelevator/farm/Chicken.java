package com.techelevator.farm;

public class Chicken implements Animal {
	
	@Override
	public String getName() {
		return "Chicken";
	}

	@Override
	public String getSound() {
		return "cluck!";
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}