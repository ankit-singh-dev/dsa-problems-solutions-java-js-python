/*
 * LeetCode 9
 * https://leetcode.com/problems/palindrome-number/
 */

package com.inn.problems;

public class LeetCode9 {

	public static void main(String[] args) {
		System.out.println(isPalindrome(313));
	}

	public static boolean isPalindrome(int x) {
		if(x < 0) {
			// if x is negative no than it is not a palindrome no
			return false;
		}
		
		int sum = 0;
		int org = x;
		while(x > 0) {
			int lastNo = x%10; 
			sum = (sum*10)+lastNo; 
			x = x/10; 
		}
		return org == sum;
	}

}
