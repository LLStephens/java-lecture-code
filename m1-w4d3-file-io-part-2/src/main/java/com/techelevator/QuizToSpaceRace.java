package com.techelevator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class QuizToSpaceRace {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream input = new FileInputStream("./quiz.txt");
		FileOutputStream output = new FileOutputStream("./space_race.txt");
		WordReplacer replacer = new WordReplacer(input, output);
		//WordReplacer replacer = new WordReplacer(input, System.out);
		replacer.replace("quiz", "Space Race");
	}

}
