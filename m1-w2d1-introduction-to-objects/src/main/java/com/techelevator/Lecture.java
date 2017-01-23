package com.techelevator;


public class Lecture {

	public static void main(String[] args) {

		System.out.println("**************************");
		System.out.println("****** CONSTRUCTORS ******");
		System.out.println("**************************");
				
		/* As an object, a String instance can be instantiated (i.e. created)
		 * using a "constructor". One of the constructors provided by the String
		 * class takes a char[] as a parameter */
		
		char[] javaArray = new char[] { 'J', 'a', 'v', 'a' };
		String javaString = new String(javaArray);  // calls a String class constructor to create a new instance of String
		System.out.println("javaString : "+javaString);
		
		/* Constructors do not need to take parameters, this is know as a "no-arg Constructor".
		 * In the case of String, the no-arg constructor creates an "empty string" (i.e. "") */
		
		String emptyString = new String();
		System.out.println("emptyString : "+emptyString);
		
		/* The String class gets special treatment in the Java language.  One 
		 * example of this is that there is a literal representation of a 
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */
		
		String greeting = "Hello, World!";  // creates a new instance of String using a literal
		System.out.println("greeting : "+greeting);
		
		System.out.println();
		System.out.println("***********************************************");
		System.out.println("****** MEMBER VARIABLES (i.e. ATTRIBUTES ******");
		System.out.println("***********************************************");
		System.out.println();
		
		/* The array length attribute is an example of a member variable. */
		
		int[] numbers = new int[10];
		System.out.println("length of numbers array is : "+numbers.length);
		
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();
		
		/* Below are examples of calling various String methods */
		
		System.out.println("***** charAt *****");
		
		String name = "Obama";
		char first = name.charAt(0);   // 'O'
		char fourth = name.charAt(3);  // 'm'
		System.out.println(name);
		System.out.println(first);
		System.out.println(fourth);
		
		
		System.out.println("***** contains *****");
		String hello = "Hello World!";
		System.out.println("hello : "+hello);
		boolean containsHello = hello.contains("Hello");
		System.out.println("containsHello : "+containsHello);
		boolean containsBogus = hello.contains("bogus");
		System.out.println("containsBogus : "+containsBogus);
		
		/* Other commonly used methods:
		 * 
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** CLASS METHODS ******");
		System.out.println("******************************");
		System.out.println();
		
		/* Any method that has the "static" modifier is known as a "class method".
		 * It can be called (i.e. invoked) using the name of the class, the dot operator, 
		 * and the name of the method. */
		
		/* String.valueOf is a class method */
		String numberString = String.valueOf(123);
		System.out.println(numberString);
		char firstNumber = numberString.charAt(0);
		System.out.println("firstNumber : "+firstNumber);
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();
		
		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
		String hello1 = new String(helloArray);
		String hello2 = new String(helloArray);
		if(hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1+" is not equal to "+hello2);
		}
		
		String hello3 = hello1;
		if(hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}
		
		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		
		if(hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1+" is not equal to "+hello2);
		}
		
	}
}
