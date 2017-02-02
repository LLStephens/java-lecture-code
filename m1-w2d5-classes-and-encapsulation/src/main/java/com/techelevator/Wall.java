package com.techelevator;

public class Wall {
	// In Feet
	private int height;
	private int width;
	
	// In inches
	private int trim;
	
	public Wall()
	{
		height = 0;
		width = 0;
		trim = 0;
	}
	
	public void setHeight(int height) {
		if(height > 0) {
			this.height = height;
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setWidth(int width) {
		if(width > 0) {
			this.width = width;
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setTrim(int trim) {
		if(trim >= 0) {
			this.trim = trim;
		}
	}
	
	public int getTrim() {
		return trim;
	}
	
	public float getArea() {
		int widthInInches = width * 12 - trim * 2;
		int heightInInches = height * 12 - trim * 2;
		
		int squareInches = widthInInches * heightInInches;
		float squareFeet = squareInches / 144.0f;
		return squareFeet;
	}
}
















