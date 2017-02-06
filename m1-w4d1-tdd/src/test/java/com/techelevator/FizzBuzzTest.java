package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Assert;

public class FizzBuzzTest {

	@Test
	public void returns_number_String_for_numbers_not_divisible_by_3_or_5() {
		Assert.assertEquals("1", FizzBuzz.fizzBuzz(1));
		Assert.assertEquals("2", FizzBuzz.fizzBuzz(2));
		Assert.assertEquals("4", FizzBuzz.fizzBuzz(4));
	}

	@Test
	public void returns_Fizz_for_multiples_of_3() {
		Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
		Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
		Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
	}
	
	@Test
	public void returns_Buzz_for_multiples_of_5() {
		Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
		Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
		Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(20));
	}
	
	@Test
	public void returns_FizzBuzz_for_multiples_of_both_3_and_5() {
		Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
		Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
		Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
	}
	
	@Test
	public void returns_Fizz_for_numbers_that_contain_the_digit_3() {
		Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(13));
		Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(23));
		Assert.assertEquals("Fizz", FizzBuzz.fizzBuzz(31));
	}
	
	@Test
	public void returns_FizzBuzz_for_numbers_that_contain_the_digit_3_and_are_divisible_by_5() {
		Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(35));
	}
	
	@Test
	public void returns_Buzz_for_numbers_that_contain_the_digit_5() {
		Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(52));
		Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(56));
		Assert.assertEquals("Buzz", FizzBuzz.fizzBuzz(58));
	}
	
	@Test
	public void returns_FizzBuzz_for_numbers_that_are_divisible_by_3_and_contain_the_digit_5() {
		Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(51));
		Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(54));
		Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(57));
	}
	
	@Test
	public void returns_FizzBuzz_for_numbers_that_contain_both_a_3_and_a_5() {
		Assert.assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(53));
	}
}
