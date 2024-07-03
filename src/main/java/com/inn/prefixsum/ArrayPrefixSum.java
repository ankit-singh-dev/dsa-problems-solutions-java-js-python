package prefixsum;

import java.util.Arrays;

public class ArrayPrefixSum {

	public static void main(String[] args) {
		int[] array = { 2, 3, 4, 1, 4, 5 };
		System.out.println(Arrays.toString(arrayPrefixSumBruteForce(array)));
		System.out.println(Arrays.toString(arrayPrefixSum(array)));
		System.out.println(Arrays.toString(prefixSum(array)));
	}

	/*
	 * time complexity : O(n) space complexity : 0(1)
	 */
	private static int[] prefixSum(int[] array) {
		int len = array.length;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += array[i];
			array[i] = sum;
		}
		return array;
	}

	/*
	 * time complexity : O(n) space complexity : 0(n)
	 */
	private static int[] arrayPrefixSum(int[] array) {
		// base case
		if (array.length == 0) {
			return new int[0];
		} else if (array.length == 1) {
			return array;
		}
		int n = array.length;
		int[] prefixSumArray = new int[n];
		prefixSumArray[0] = array[0];

		for (int i = 1; i < n; i++) {
			prefixSumArray[i] = prefixSumArray[i - 1] + array[i];
		}

		return prefixSumArray;
	}

	/*
	 * time complexity : O(n2) space complexity : 0(n)
	 */
	private static int[] arrayPrefixSumBruteForce(int[] array) {
		// base case
		if (array.length == 0) {
			return new int[0];
		} else if (array.length == 1) {
			return array;
		}
		int n = array.length;
		int[] prefixSumArray = new int[n];
		prefixSumArray[0] = array[0];
		for (int i = 1; i < n; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum = sum + array[j];
			}
			prefixSumArray[i] = sum;
		}
		return prefixSumArray;
	}

}
