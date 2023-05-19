package com.inn.twopointers;

/*
 * https://www.geeksforgeeks.org/two-pointers-technique/
 */

public class PairInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 35, 50, 75, 80 };
		int x = 70;
		printPairsUsingBruteForce(arr,x);
		printPairsUsing2Pointers(arr, x);
	}
	
	private static void printPairsUsing2Pointers(int[] arr,int x) {
		int start = 0;
		int end = arr.length-1;
		while(start < end) {
			if(arr[start] + arr[end] > x) {
				end--;
			}else if(arr[start] + arr[end] < x) {
				start++;
			}else {
				System.out.println(arr[start] + " " + arr[end]);
				start++;
				end--;
			}
		}
	}

	private static void printPairsUsingBruteForce(int[] arr,int x) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == x) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
	}

}
