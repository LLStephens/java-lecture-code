package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator calc;

	@Before
	public void setup() {
		// Arrange
		calc = new Calculator();
	}
	
	@Test
	public void varify_that_1_plus_three_equals_four() {
		// Act
		int result = calc.add(3);
		
		// Assert
		Assert.assertEquals(3, result);
		Assert.assertEquals("After adding 0+3 we expected the result to be 3", 3, calc.getResult());
	}
}
