package com.techelevator;

/**
 * This class represents a very simple calculator with limited functions. It can add, subtract, multiply, and raise to a power. 
 */
public class Calculator {
	
	//
	// Add any properties, along with getters and/or setters, that may be needed to implements the class methods and/or constructors.
	//
	private int result;
	
	/**
	 * The no-arg constructor initializes the result to zero.
	 */
	public Calculator() {
		result = 0;
	}

	/**
	 * This constructor initializes the result to the int value provided as an argument.
	 * 
	 * @param startingResult the value that result should be initialized to
	 */
	public Calculator(int startingResult) {
		result = startingResult;
	}
	
	/**
	 * Returns the current value of the running result.
	 * @return the current result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * This method adds the provided value to the result
	 * 
	 * @param addend the value to be added to the current result
	 * @return the result after adding addend
	 */
	public int add(int addend) {
		return result += addend;
	}

	/**
	 * This method subtracts the provided value from the result.
	 * 
	 * @param subtrahend the value to be subtracted from the current result
	 * @return the result after subtracting subtrahend
	 */
	public int subtract(int subtrahend) {
		return result -= subtrahend;
	}

	/**
	 * This method multiplies the current result by multiplier.
	 * 
	 * @param multiplier the value to multiply the result by
	 * @return the result after multiplying by multiplier
	 */
	public int multiply(int multiplier) {
		return result *= multiplier;
	}

	/**
	 * This method raises the current result by the power of exponent.  Negative exponents are not supported. 
	 * If a negative exponent is provided, it is treated as though it were positive (i.e. uses the
	 * absolute value)
	 * 
	 * For example: calculator.pow(-2) is equal to calculator.pow(2)
	 * 
	 * @param exponent the power to raise by
	 * @return the current result raised by the power of exponent
	 */
	public int power(int exponent) {
//		if(exponent < 0) {
//			exponent *= -1;
//		}
//		
//		for(int i = 0; i < exponent; i++) {
//			result *= result;
//		}
		
		result = (int)Math.pow(result, Math.abs(exponent));
		
		return result;
	}

	/**
	 * Calling this method sets the running result to 0.
	 */
	public void reset() {
		result = 0;
	}

}











