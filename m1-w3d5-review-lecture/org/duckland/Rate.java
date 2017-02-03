package org.duckland;

public class Rate {
	private final double rate;
	private final String name;
	
	public Rate(String name, double rate) {
		this.rate = rate;
		this.name = name;
	}
	
	public double getRate() {
		return rate;
	}
	
	public String getName() {
		return name;
	}
}