package com.techelevator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;

public class WordReplacerTest {

	private OutputStream output;
	
	@Before
	public void setup() {
		output = new ByteArrayOutputStream();
	}
	
	@Test
	public void reads_data_from_input_and_writes_to_output() {
		String inputData = "Hello, World!";
		WordReplacer replacer = getWordReplacerForTesting(inputData);
		
		replacer.replace("Foo", "Bar");
		
		String outputData = output.toString();
		assertEquals(inputData, outputData);
	}

	@Test
	public void reads_every_line_of_input_and_writes_to_ouput() {
		String inputData = "Hello, World!\nHow are you?";
		WordReplacer replacer = getWordReplacerForTesting(inputData);
		
		replacer.replace("Foo", "Bar");
		
		String outputData = output.toString();
		assertEquals(inputData, outputData);
	}
	
	@Test
	public void replaces_matching_words_from_input_before_writing_to_output() {
		String inputData = "Happy birthday to you, happy birthday to you!";
		WordReplacer replacer = getWordReplacerForTesting(inputData);
		
		replacer.replace("birthday", "Festivus");
		
		String outputData = output.toString();
		assertEquals("Happy Festivus to you, happy Festivus to you!", outputData);
	}
	
	public WordReplacer getWordReplacerForTesting(String inputData) {
		InputStream input = new ByteArrayInputStream(inputData.getBytes());
		return new WordReplacer(input, output);
	}
}
