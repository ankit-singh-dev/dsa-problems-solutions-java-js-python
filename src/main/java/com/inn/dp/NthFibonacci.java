package com.inn.dp;

public class NthFibonacci {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(nthFibonacci(n));
		System.out.println(nthFibonacciUsingRecursion(n));
		System.out.println(nthFiboUsingDp(n, new int[n+1]));
	}
	
	private static int nthFiboUsingDp(int n,int[] nthRecursion) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		System.out.println("hello dp 123 "+n);
		// memoization
		if(nthRecursion[n] != 0) {
			return nthRecursion[n];
		}
		
		int fiboOfNMinusOne = nthFiboUsingDp(n-1,nthRecursion);
		int fiboOfNMinusTwo = nthFiboUsingDp(n-2,nthRecursion);
		int result = fiboOfNMinusOne + fiboOfNMinusTwo;
		nthRecursion[n] = result;
		return result;
	}
	
	private static int nthFibonacciUsingRecursion(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		System.out.println("hello "+n);
		int fiboOfNMinusOne = nthFibonacciUsingRecursion(n-1);
		int fiboOfNMinusTwo = nthFibonacciUsingRecursion(n-2);
		
		return fiboOfNMinusOne + fiboOfNMinusTwo;
	}

	private static int nthFibonacci(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		int firstNo = 0;
		int secondNo = 1;
		int thirdNo = 0;
		for (int i = 2; i <= n; i++) {
			thirdNo = firstNo + secondNo;
			firstNo = secondNo;
			secondNo = thirdNo;
		}
		return thirdNo;
	}

}
