package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {
		
		Animal[] farmAnimals = new Animal[] { new Cow(), new Chicken(), new Sheep() };
		
		for(Animal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a "+name+", ee, ay, ee, ay, oh!");
			System.out.println("With a "+sound+" "+sound+" here");
			System.out.println("And a "+sound+" "+sound+" there");
			System.out.println("Here a "+sound+" there a "+sound+" everywhere a "+sound+" "+sound);
			System.out.println();
			
			if(animal instanceof Cow) {
				System.out.println("This is a cow");
			} else if(animal instanceof Sheep) {
				System.out.println("This is a sheep");
			} else if(animal instanceof Chicken) {
				System.out.println("This is a chicken");
			} else {
				System.out.println("I have no idea what this is!");
			}
			
			System.out.println();
		}
	}
}

















