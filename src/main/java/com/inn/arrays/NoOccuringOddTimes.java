package com.inn.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 */

public class NoOccuringOddTimes {

	public static void main(String[] args) {
		int[] arr = {5, 7, 2, 7, 5, 2, 5};
		int result = usingHashMap(arr);
		System.out.println(result);
	}
	
	private static int usingHashMap(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int no : arr) {
			map.put(no, map.getOrDefault(no, 0)+1);
		}
		for(Entry<Integer, Integer> no : map.entrySet()) {
			if(no.getValue() % 2 != 0) {
				return no.getKey();
			}
		}
		return -1;
	}

	private static int bruteForceApproach(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int count = 0;
			for(int j=0;j<arr.length;j++) {
				if(arr[j] == arr[i]) {
					count++;
				}
			}
			if(count % 2 != 0) {
				return arr[i];
			}
		}
		return -1;
	}
	
	

}
