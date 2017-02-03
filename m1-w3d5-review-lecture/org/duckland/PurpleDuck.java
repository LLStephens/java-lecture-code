package org.duckland;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PurpleDuck {
	public static void main(String[] args) {
		DeliveryDriver[] drivers = new DeliveryDriver[] { /*new SPU(), */new PostalService()/*, new FexEd()*/ };
		
		Scanner input = new Scanner(System.in);
		
		// Get user input
		System.out.println("Enter weight of package:");
		
		int weight = input.nextInt();
		input.nextLine();
		
		System.out.println("Is this (P)ounds or (O)unces?");
		
		String units = input.nextLine();
		if(units.equalsIgnoreCase("P")) {
			weight *= 16;
		}
		
		System.out.println("How far will the package go?");
		int distance = input.nextInt();
		input.nextLine();
		
		for(DeliveryDriver driver : drivers) {
			for(Rate rate : driver.calculateRate(weight, distance)) {
				System.out.println(rate.getName() + "\t" + rate.getRate());
			}
		}
	}
}