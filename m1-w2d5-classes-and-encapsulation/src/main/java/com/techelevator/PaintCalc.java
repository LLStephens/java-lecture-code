package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaintCalc {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Wall> wallList = new ArrayList<Wall>();
		Paint ourPaint = new Paint(400);
		
		while(true) {
			
			System.out.println();
			System.out.println("[1] Add a wall");
			System.out.println("[2] Calculate paint required (and Exit)");
			System.out.print("Please choose >>> ");
			String userChoice = scan.nextLine();
			
			System.out.println();
			
			if(userChoice.equals("1")) {
				
				Wall wall = new Wall();
				
				System.out.print("Enter wall height >>> ");
				int height = Integer.parseInt(scan.nextLine());
				wall.setHeight(height);
				
				System.out.print("Enter wall width >>> ");
				int width = Integer.parseInt(scan.nextLine());
				wall.setWidth(width);

				System.out.println("Added "+wall.getHeight()+"x"+wall.getWidth()+" wall - "+wall.getArea()+" square feet");
				
				wallList.add(wall);
				
			} else if(userChoice.equals("2")) {
				
				float totalArea = 0;
				for(Wall wall : wallList) {
					totalArea += wall.getArea();
					System.out.println(wall.getHeight() + "x" + wall.getWidth() + " - " + wall.getArea() + " square feet");
				}

				System.out.println("===============================");
				System.out.println("Total Area: "+totalArea+" square feet");
				System.out.println("Paint Required: "+ourPaint.calculateGallons(totalArea)+" gallons");
				
				System.exit(0); // Causes the program to end
			}
		}
	}

}

















