/*
 * Leetcode 344 problems
 * https://leetcode.com/problems/reverse-string/
 */

package com.inn.problems;

import java.util.Arrays;

public class LeetCode344 {

	public static void main(String[] args) {
		char[] s = {'h','e','l','l','0'};
		reverseString(s);
	}

	public static void reverseString(char[] s) {
		int start = 0;
		int end = s.length-1;
		
		while(start <= end) {
			char tempChar = s[start];
			s[start] = s[end];
			s[end] = tempChar;
			
			start++;
			end--;
		}
		
		System.out.println(Arrays.toString(s));
	}

}
