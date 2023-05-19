package com.inn.sortingsearching;

import java.math.BigInteger;

/*
 * https://leetcode.com/problems/sqrtx/description/
 */

public class Leetcode69 {

	public static void main(String[] args) {
		int x = 587820025;
		System.out.println(mySqrt(x));
		System.out.println(usingBinarySearch(x));
	}
	
	private static int usingBinarySearch(int x) {
		int start = 1;
		int end = x;
		int ans = 0;
		while(start <= end) {
			int mid = start + (end-start)/2;
			BigInteger bigMid = BigInteger.valueOf(mid);
			BigInteger bigSqrt = bigMid.multiply(bigMid);
			int cmp = bigSqrt.compareTo(BigInteger.valueOf(x));
			if(cmp == 0) {
				return mid;
			}else if(cmp < 0) {
				// negative no
				ans = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return ans;
	}
	
	private static int mySqrt(int x) {
		int i = 1;
		int count = 0;
		while(x >= 0) {
			x = x - i;
			i = i+2;
			count++;
		}
		return count-1;
	}

}
