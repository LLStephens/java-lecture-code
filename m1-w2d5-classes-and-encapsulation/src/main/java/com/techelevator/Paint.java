package com.techelevator;

public class Paint {
	private final float squareFeetPerGallon;
	
	public Paint(float squareFeetPerGallon) {
		this.squareFeetPerGallon = squareFeetPerGallon;
	}
	
	public float calculateGallons(float squareFeet) {
		return squareFeet / squareFeetPerGallon;
	}
}
