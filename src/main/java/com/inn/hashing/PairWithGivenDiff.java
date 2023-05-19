package com.inn.hashing;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.interviewbit.com/problems/pair-with-given-difference/
 */

public class PairWithGivenDiff {

	public static void main(String[] args) {
		int[] A = { 20, 500, 1000, 200  };
		int B = 0;
		System.out.println(solveUsingBruteForce(A, B));
		System.out.println(solveUsingHashing(A, B));
	}
	
	private static int solveUsingHashing(int[] A,int B) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int no : A) {
			int existingCount = map.getOrDefault(no, 0);
			map.put(no, existingCount+1);
		}
		
		for(int no : A) {
			int diff = B + no;
			if(map.containsKey(diff)) {
				// check to see if B = 0
				if(B == 0) {
					if(map.get(diff) > 1) {
						return 1;
					}
				}else {
					return 1;
				}
			}
		}
		return 0;
	}

	private static int solveUsingBruteForce(int[] A, int B) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i != j) {
					int diff = A[i] - A[j];
					if (diff == B) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

}
