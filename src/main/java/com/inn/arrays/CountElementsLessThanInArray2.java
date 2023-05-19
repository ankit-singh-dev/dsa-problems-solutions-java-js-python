package com.inn.arrays;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * https://www.geeksforgeeks.org/element-1st-array-count-elements-less-equal-2nd-array/
 * 
*/

public class CountElementsLessThanInArray2 {

	public static void main(String[] args) {
		int[] arr1 = new int[] { 5, 10, 2, 6, 1, 8, 6, 12 };
		int[] arr2 = new int[] { 6, 5, 11, 4, 2, 3, 7 };
		int[] res = naiveSolution(arr1, arr2);
		printArrayElements(res);
		
		arr1 = new int[] { 5, 10, 2, 6, 1, 8, 6, 12 };
		arr2 = new int[] { 6, 5, 11, 4, 2, 3, 7 };
		res = usingSortingAndBinarySearch(arr1, arr2);
		printArrayElements(res);
	}
	
	private static void printArrayElements(int[] array) {
		Arrays.stream(array).forEach(no -> System.out.print(no + " "));
		System.out.println();
	}

	private static int[] usingSortingAndBinarySearch(int[] arr1, int[] arr2) {
		// time complexity : O(mlogn + nlogn)
		// space comlexity : O(n)
		int[] returnArray = new int[arr1.length];
		Arrays.sort(arr2);
		int i = 0;
		for (int no : arr1) {
			int res = findLastIndexLessThanOrEqualToNo(no, arr2);
			returnArray[i++] = res + 1;
		}
		return returnArray;
	}

	private static int findLastIndexLessThanOrEqualToNo(int no, int[] sortedArray) {
		int start = 0;
		int end = sortedArray.length - 1;
		// corner case
		if (no < sortedArray[start]) {
			return -1;
		} else if (no > sortedArray[end]) {
			return end;
		}
		// corner case end
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (sortedArray[mid] <= no) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return end;
	}

	private static int[] naiveSolution(int[] arr1, int[] arr2) {
		// time complexity : O(m*n)
		// space complexity : O(1)
		int m = arr1.length;
		int n = arr2.length;
		for (int i = 0; i < m; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (arr1[i] >= arr2[j]) {
					count++;
				}
			}
			arr1[i] = count;
		}
		return arr1;
	}

	// test cases
	@Test
	public void testCaseOfNaiveSolution() {
		int[] arr1 = { 5, 10, 2, 6, 1, 8, 6, 12 };
		int[] arr2 = { 6, 5, 11, 4, 2, 3, 7 };
		int[] actual = naiveSolution(arr1, arr2);
		int[] expected = { 4, 6, 1, 5, 0, 6, 5, 7 };
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testCaseOfBinarySearch() {
		int[] arr1 = { 5, 10, 2, 6, 1, 8, 6, 12 };
		int[] arr2 = { 6, 5, 11, 4, 2, 3, 7 };
		int[] actual = usingSortingAndBinarySearch(arr1, arr2);
		int[] expected = { 4, 6, 1, 5, 0, 6, 5, 7 };
		Assertions.assertArrayEquals(expected, actual);
	}

}
