package com.jlhuertas.csproblems;

public class SortingProblems {
	
	/**
	 * Given a char array with upper case, lower case letters and numbers (such as “MobB3e1”) order it in such a way 
	 * that the output is composed first by lower case, then upper case, then numbers (i.e.: “obeMB31”). 
	 * Order doesn't matter within the same group (i.e.: “obeMB31” and "obeBM13" would be equally valid outputs)
	 * Do it in O(n) with just one pass and don't use additional storage.
	 * 
	 * This seems a variant of the Dutch National Flag problem proposed by Dijkstra (http://en.wikipedia.org/wiki/Dutch_national_flag_problem).
	 * 
	 * 
	 * @param inputArray Array of chars to be sorted. This array is modified and the output is an array of chars sorted in three categories 
	 * (all lower case at the beginning, all upper case in the middle and all numbers in the end)
	 */
	public void sortLowercaseUppercaseNumbers(char[] array) {
		
		//two indexes, the lower case group will grow up from the bottom and the numbers group will grow down from the top
		int lowerCaseIndex = 0;
		int numberIndex = array.length - 1;
		
		//another index to iterate through the array
		int i = 0;
		while (i <= numberIndex) {
			//move lower cases at the beginning, digits at the end and let upper case in the middle
			if (Character.isLowerCase(array[i])) {
				swap(i++, lowerCaseIndex++, array);
			} else if (Character.isDigit(array[i])) {
				swap(i, numberIndex--, array);
			} else {
				//upper case
				i++;
			}
		}
		

	}
	
	/**
	 * Swaps two positions of an array.
	 * This swap function DOES NOT use temporary variables (http://en.wikipedia.org/wiki/XOR_swap_algorithm). 
	 * Note that this usually is not practical nor from a readability point of view neither from a performance point 
	 * of view, but hey! isn't it cool? :)
	 * 
	 * 
	 * @param x one of the indexes to swap
	 * @param y the other index to swap
	 * @param arr Array that contains the elements to be swapped.
	 */
	public void swap(int x, int y, char[] arr) {
		if (x != y && arr != null && (x >= 0 && x <= arr.length) && (y >= 0 && y <= arr.length)) {
			arr[x] = (char) (arr[x] ^ arr[y]);
			arr[y] = (char) (arr[x] ^ arr[y]);
			arr[x] = (char) (arr[x] ^ arr[y]);
		}
	}

}
