package prefixsum;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 * https://leetcode.com/problems/find-pivot-index/description/
 */

public class EquilibriumIndexOfArray {

	/*
	 * time complexity : O(n)
	 */
	private static int optimizedWayUsingPrefixSum(int[] array) {
		int len = array.length;
		int rightSum = Arrays.stream(array).sum();
		int leftSum = 0;
		for (int i = 0; i < len; i++) {
			rightSum = rightSum - array[i];
			if (leftSum == rightSum) {
				return i;
			}
			leftSum = leftSum + array[i];
		}

		return -1;
	}

	/*
	 * time complexity : O(n2)
	 */
	private static int bruteforceApproach(int[] array) {
		int n = array.length;
		for (int i = 1; i < n - 1; i++) {
			int sum1 = 0;
			int sum2 = 0;
			for (int j = 0; j < i; j++) {
				sum1 = sum1 + array[j];
			}
			for (int j = i + 1; j < n; j++) {
				sum2 = sum2 + array[j];
			}
			if (sum1 == sum2) {
				return i;
			}
		}
		return -1;
	}

}
