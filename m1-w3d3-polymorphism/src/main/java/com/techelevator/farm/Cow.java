package com.techelevator.farm;

public class Cow implements Animal {

	@Override
	public String getName() {
		return "Cow";
	}

	@Override
	public String getSound() {
		return "moo!";
	}

}