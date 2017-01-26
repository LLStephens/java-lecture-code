package com.techelevator;

import static org.hamcrest.CoreMatchers.instanceOf;

public class Dog {
	private int age;
	private String name;
	
	public Dog(int age, String name) {
		setAge(age);
		setName(name);
	}
	
	public void bark() {
		System.out.println("Woof!");
	}
	
	public void fetch(String thingToFetch) {
		System.out.println("Go get the " + thingToFetch);
	}
	
	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		if(name != null && !name.isEmpty()) {
			this.name = name;
		}
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if(obj instanceof Dog){
			Dog otherDog = (Dog)obj;
			if(name.equals(otherDog.getName()) && age == otherDog.getAge()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}





















