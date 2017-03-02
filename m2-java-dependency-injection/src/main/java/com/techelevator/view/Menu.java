package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}
	
	public String getProductSelection() {
		out.println("\nPlease chose a product");
		out.flush();
		String userInput = in.nextLine();
		
		// TODO: Some validation?
		return userInput;
	}
	
	public int getMoney() {
		out.println("\nInsert money is whole dollar amounts (e.g. $1, $2, $5, $10)");
		out.flush();
		String userInput = in.nextLine();
		
		if(userInput.startsWith("$")) {
			userInput = userInput.replaceAll("\\$", "");
		}
		
		int dollars = 0;
		try {
			dollars = Integer.parseInt(userInput);
		} catch(NumberFormatException ex) {
			System.out.println("\n" + userInput + " is not a valid dollar amount.");
		}

		if(dollars != 1 && dollars != 2 && dollars != 5 && dollars != 10 && dollars != 20) {
			System.out.println("\nGet out of here with that " + dollars + " dollar bill!");
			dollars = 0;
		}
		
		return dollars;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			out.println(optionNum+") "+options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
}
