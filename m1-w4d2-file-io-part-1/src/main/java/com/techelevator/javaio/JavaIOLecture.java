package com.techelevator.javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaIOLecture {

	public static void main(String[] args) throws IOException {
		
		/* char can be treated as a numeric data type */
		char letter = 'A';
		int number = letter;
		System.out.println(letter+" is "+number);
		System.out.println("Next letter is "+(char)(number+1));
		System.out.println();
		
		/* here we are reading user input as binary data using the stdin InputStream. 
		 * Try entering a unicode character such as Ω (use option-Z) and observe what
		 * is read */
		System.out.print("Enter some data for me to read >>> ");
		int input = System.in.read();  // reads one byte of data
		while(input != '\n') {
			System.out.print(input+" ");
			input = System.in.read();
		}
		System.out.print("\n\n");
		
		/* here we wrap the InputStream in a InputStreamReader so that we can 
		 * read one character (2 bytes) at a time. The best way to see the difference
		 * is to use a unicode character such as Ω (option-Z to type this on Mac) */
		InputStreamReader reader = new InputStreamReader(System.in);
		System.out.print("Enter some data for me to read >>> ");
		input = reader.read();  // reads two bytes of data (i.e. one unicode character)
		while(input != '\n') {
			System.out.print(input+" ");
			input = reader.read();
		}
		System.out.print("\n\n");
		
		/* If we want to read an entire line of input (all characters prior to a newline)
		 * we can use a BufferedReader.  Here we wrap the InputStreamReader we created 
		 * earlier in a BufferedReader */
		BufferedReader lineReader = new BufferedReader(reader);
		System.out.print("Enter some data for me to read >>> ");
		String inputLine = lineReader.readLine();  // reads an entire line of data (all characters prior to a newline)
		System.out.println(inputLine);
	}
}
