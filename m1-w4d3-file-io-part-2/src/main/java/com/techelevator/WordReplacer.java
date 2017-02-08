package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordReplacer {

	private Scanner inputScanner;
	private PrintWriter outputWriter;
	
	public WordReplacer(InputStream input, OutputStream output) {
		inputScanner = new Scanner(input);
		outputWriter = new PrintWriter(output);
	}
	
	public void replace(String wordToReplace, String replacementWord) {
		while(inputScanner.hasNextLine()) {
			String inputData = inputScanner.nextLine();
			outputWriter.print(inputData.replace(wordToReplace, replacementWord));
			if(inputScanner.hasNextLine()) {
				outputWriter.print("\n");
			}
		}
		outputWriter.flush();
	}
}
