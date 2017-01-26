package com.techelevator;

public class Main {
	public static void main(String[] args) {
		Dog myDog = new Dog(9, "Bart");
		Dog myDogAgain = new Dog(9, "Bart");
		Dog myOtherDog = new Dog(9, "Jax");
		
		if(myDog == myOtherDog) {
			System.out.println(myDog.getName() + " and " + myOtherDog.getName() + " are the same dog");
		} else {
			System.out.println(myDog.getName() + " and " + myOtherDog.getName() + " are different");
		}
		
		if(myDog.equals(myDogAgain)) {
			System.out.println(myDog.getName() + " and " + myDogAgain.getName() + " are the same dog");
		} else {
			System.out.println(myDog.getName() + " and " + myDogAgain.getName() + " are different");
		}
		
		myDog.bark();
		myDog.fetch("toy");
	}
}
