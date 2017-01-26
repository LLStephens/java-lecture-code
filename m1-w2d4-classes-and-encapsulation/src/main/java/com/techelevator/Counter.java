package com.techelevator;

public class Counter {
	private static int globalCount = 0;  // declaring this variable as static means that is shared by all instances of Counter
	private int myCount;
	
	public Counter() {
		myCount = 0;
	}
	
	public void increment() {
		globalCount++;  // this static variable can be referenced from an instance method because statics are available to all instances of a class
		myCount++;
	}
	
	public int getMyCount() {
		return myCount;
	}
	
	public static int getGlobalCount() {
		//return myCount; // this is a compiler error because you cannot reference instance variables from a static method
		//getMyCount();  // this is a compiler error because you cannot reference a instance method from a static method
		return globalCount;
	}
}
