package com.techelevator;

import com.techelevator.farm.Animal;
import com.techelevator.farm.Chicken;
import com.techelevator.farm.Cow;

public class Lecture {

	public static void main(String[] args) {
		
		/* You cannot create an instance of an interface type */
		
		//Animal animal = new Animal();  // this causes a compiler error
		
		/* A child-type instance may be assigned to a parent-type reference.
		 * In this case, a Cow "is-a" Animal since Cow implements Animal.  
		 * Therefore, we can assign a new instance of Cow to a reference 
		 * variable of type Animal */
		
		Animal anAnimal = new Cow();
		
		/* When we call interface methods, it is actually the implementing 
		 * class's methods that get invoked. */
		
		String animalName = anAnimal.getName(); // invokes Cow.getName()
		String sound = anAnimal.getSound(); // invokes Cow.getSound()
		System.out.println(animalName + " says "+sound);
		
		/* Class's that implement an interface can also define other methods 
		 * that are not part of the interface. */
		
		Chicken aChicken = new Chicken();
		aChicken.layEgg();  // layEgg is not defined as part of the Animal interface
		
		/* If a child-type instance is referred to using a parent-type reference, only 
		 * methods of the parent-type are available */
		
		Animal genericAnimal = aChicken;  // assigning a Chicken reference to a variable of parent-type Animal
		// genericAnimal.layEgg();  // this causes a compiler error because genericAnimal is a reference of type Animal and layEgg() is not a method of type Animal
	}

}
