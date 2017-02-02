package com.techelevator;

import java.util.Scanner;

public class Lecture {
	public static void main(String[] args) {
		
		int targetNumber;
		int maxGuesses = 5;
		boolean isPlaying = true;
		
		Scanner input;
		input = new Scanner(System.in);
		
		while(isPlaying) {
			System.out.println("Welcome to best game in the world! Pick a number between 1 and 100.");
			System.out.println("1) 5 Guesses\n2) 10 Guesses\n3) 15 Guesses");
			
			int option = input.nextInt();
			input.nextLine();
			
			if(option == 1) {
				maxGuesses = 5;
			} else if(option == 2) {
				maxGuesses = 10;
			} else {
				maxGuesses = 15;
			}
			
			targetNumber = (int)((Math.random() * 100) + 1);
			
			System.out.println("You have " + maxGuesses + " guesses. Begin.");
			
			for(int i = 0; i < maxGuesses; i++) {
				int guess = input.nextInt();
				input.nextLine();
				
				if(guess < 1 || guess > 100) {
					System.out.println("We said 1 to 100, try agin.");
					i--;
				} else if(guess == targetNumber) {
					System.out.println("You win! Great job!");
					System.exit(0);
				} else if (i < maxGuesses - 1) {
					System.out.println("Total Fail! Try again!");
					
					if(guess > targetNumber) {
						System.out.println("Your guess was too high.");
					} else {
						System.out.println("Your guess was too low.");
					}
					
					System.out.println("You have " + (maxGuesses - i - 1) + " guesses left.");

				} else {
					System.out.println("It's over give up now!");
					System.out.println("You were trying to get " + targetNumber);
					System.out.println("Would you like to play again? (y/n)");
					
					String again = input.nextLine();
					if(again.equals("y")) {
						isPlaying = true;
					} else {
						isPlaying = false;
					}
				}
			}
		}
	}
}



















