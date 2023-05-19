package com.inn.recursion;

public class PrintDesc {

	public static void main(String[] args) {
		int n = 20;
		printDesc(n);
		System.out.println();
		printInsc(n);
	}
	
	private static void printDesc(int n) {
		if(n == 0) {
			return;
		}
		System.out.print(n + " ");
		printDesc(n-1);
	}
	
	private static void printInsc(int n) {
		if(n == 0) {
			return;
		}
		printInsc(n-1);
		System.out.print(n + " ");
	}

}
