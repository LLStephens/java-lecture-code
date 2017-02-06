package com.techelevator;

public class FizzBuzz {

	public static String fizzBuzz(int number) {
		
		if( isFizz(number) && isBuzz(number) ) {
			return "FizzBuzz";
		} else if( isFizz(number) ) {
			return "Fizz";
		} else if( isBuzz(number) ) {
			return "Buzz";
		} else {
			return String.valueOf(number);
		}
	}

	private static boolean isBuzz(int number) {
		return isDivisibleBy5(number) || containsDigit5(number);
	}

	private static boolean isFizz(int number) {
		return isDivisibleBy3(number) || containsDigit3(number);
	}

	private static boolean containsDigit3(int number) {
		return String.valueOf(number).contains("3");
	}

	private static boolean containsDigit5(int number) {
		return String.valueOf(number).contains("5");
	}

	private static boolean isDivisibleBy5(int number) {
		return number % 5 == 0;
	}

	private static boolean isDivisibleBy3(int number) {
		return number % 3 == 0;
	}
	
	public static void main(String[] args) {

		System.out.println("The FizzBuzz numbers between 1 and 100:");
		System.out.println("---------------------------------------");
		for(int i = 1; i <= 100; i++) {
			System.out.println(FizzBuzz.fizzBuzz(i));
		}
	}
}
