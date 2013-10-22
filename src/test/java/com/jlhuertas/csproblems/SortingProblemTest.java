/**
 * 
 */
package com.jlhuertas.csproblems;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;

/**
 * Test cases for the SortingProblems class.
 * 
 * @author jlhuertas
 * 
 */
public class SortingProblemTest {

	private static final int ARRAY_MAX_LENGTH = 1000000;
	
	private static final char[] VALID_CHARS = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	private SortingProblems sortingProblems;

	@Before
	public void setup() {
		this.sortingProblems = new SortingProblems();
	}

	@Test
	public void testXORSwap() {
		char[] array = { 'a', 'b' };
		sortingProblems.swap(0, 1, array);
		assertThat(array, is(equalTo(new char[] { 'b', 'a' })));

		array = new char[] { 'a', 'b', 'c' };
		sortingProblems.swap(0, 2, array);
		assertThat(array, is(equalTo(new char[] { 'c', 'b', 'a' })));

		array = new char[] { 'a', 'b', 'c' };
		sortingProblems.swap(-1, 5, array);
		assertThat(array, is(equalTo(new char[] { 'a', 'b', 'c' })));
		
		array = new char[] { 'a' };
		sortingProblems.swap(0, 0, array);
		assertThat(array, is(equalTo(new char[] { 'a' })));

		array = null;
		sortingProblems.swap(0, 0, array);
		assertThat(array, is(equalTo(null)));

	}

	@Test
	public void testArraySort() {
		char[] array = { 'M', 'o', 'b', 'B', '3', 'e', '1' };
		sortingProblems.sortLowercaseUppercaseNumbers(array);
		testLowerCaseUpperCaseNumbersOrder(array);
	}

	@Test
	public void testArraySort1() {
		char[] array = { '1', '2', '3', 'A', 'B', 'C', 'a', 'b', 'c'};
		sortingProblems.sortLowercaseUppercaseNumbers(array);
		testLowerCaseUpperCaseNumbersOrder(array);
	}
	
	@Test
	public void testArrayRandom() {
		//generate an array with random length and random content
		Random random = new Random();
		int length = random.nextInt(ARRAY_MAX_LENGTH);
		
		char[] array = new char[length];
		for (int i = 0; i < length; i++) {
			array[i] = VALID_CHARS[random.nextInt(VALID_CHARS.length)];
		}
		
		//sort
		sortingProblems.sortLowercaseUppercaseNumbers(array);
		
		//test sorting
		testLowerCaseUpperCaseNumbersOrder(array);
	}
	
	@Test
	public void testEmptyArray() {
		char[] array = { '1', '2', '3', 'A', 'B', 'C', 'a', 'b', 'c'};
		sortingProblems.sortLowercaseUppercaseNumbers(array);
		testLowerCaseUpperCaseNumbersOrder(array);
	}
	
	/**
	 * Tests if the input array is sorted with all the lower case letters at the beginning, upper case letters in the middle
	 * and number at the end.
	 * @param array
	 */
	private void testLowerCaseUpperCaseNumbersOrder(char[] array) {
		boolean upperCaseFound = false;
		boolean numberFound = false;
		for (int i = 0; i < array.length; i++) {
			if (Character.isLowerCase(array[i])) {
				if (upperCaseFound || numberFound) {
					fail("Lower case after upper case or digit found");
				}
			} else if (Character.isUpperCase(array[i])){
				upperCaseFound = true;
				if (numberFound) {
					fail("Upper case after digit found");
				}				
			} else if (Character.isDigit(array[i])){
				numberFound = true;
			} else {
				fail("No other characters other than upper case, lower case or digits should appear");
			}
			
		}
	}
}
