package com.techelevator;


public class Lecture {
	
	public static final int DAYS_IN_WEEK = 7;  // declaring a variable as static final means that the value is a constant
	
	public static void main(String[] args) {
		
		/**********************
		 *    MEMBER ACCESS   *
		 **********************/
		Automobile car = new Automobile();
		System.out.println("Turn the car on.");
		car.turnOn();
		System.out.println("Put the car in drive.");
		car.engageDrive();
		System.out.println("Press the gas pedal.");
		car.accelerate();
		car.accelerate();
		car.accelerate();
		System.out.println("We are now traveling "+car.getCurrentSpeed()+"mph");
		System.out.println("Attempt to put the car in reverse.");
		if(car.engageReverse()) {
			System.out.println("CRUNCH!!!");
		} else {
			System.out.println("Need to stop before car will go in reverse...");
		}
		System.out.println();
		
		/***************
		 *    STATIC   *
		 ***************/
		Counter a = new Counter(); // a.myCount : 0, Counter.globalCount : 0
		Counter b = new Counter(); // a.myCount : 0, Counter.globalCount : 0
		
		a.increment(); // a.myCount : 1, Counter.globalCount : 1
		a.increment(); // a.myCount : 2, Counter.globalCount : 2
		a.increment(); // a.myCount : 3, Counter.globalCount : 3
		b.increment(); // b.myCount : 1, Counter.globalCount : 4
		
		System.out.println("a.getMyCount() : "+a.getMyCount()); 
		System.out.println("b.getMyCount() : "+b.getMyCount());
		System.out.println("Counter.getGlobalCount() : "+Counter.getGlobalCount());
		
		
		/**************
		 *    FINAL   *
		 **************/
		
		final int dontChangeMe;  // a final variable may not be changed after it has been initialzed.
		
		dontChangeMe = 1;		// here we are initializing dontChangeMe
		
		// dontChangeMe = 2; // compile error because dontChangeMe has already been initialized
	}
}
