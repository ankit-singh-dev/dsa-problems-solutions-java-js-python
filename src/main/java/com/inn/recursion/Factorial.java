package com.inn.recursion;

public class Factorial {

	public static void main(String[] args) {
		int res = fact(5);
		System.out.println(res);
	}
	
	private static int fact(int n) {
		if(n == 1) {
			return 1;
		}
		int result = fact(n-1);
		return n * result;
	}

}
