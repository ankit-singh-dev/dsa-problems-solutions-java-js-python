package com.inn.recursion;

public class CalculatePower {

	public static void main(String[] args) {
		int x = 3;
		int n = 4;
		System.out.println(powerUsingLoops(x, n));
		System.out.println(powerUsingRecursion(x, n));
		System.out.println(powerUsingRecursionUsingLog(x, n));
	}

	private static int powerUsingLoops(int x, int n) {
		int power = 1;
		for (int i = 1; i <= n; i++) {
			power *= x;
		}
		return power;
	}

	private static int powerUsingRecursion(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int pnm1 = powerUsingRecursion(x, n - 1);
		int pn = pnm1 * x;
		return pn;
	}

	private static int powerUsingRecursionUsingLog(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int powerDivN = powerUsingRecursionUsingLog(x, n / 2);
		int res = powerDivN * powerDivN;
		if (n % 2 != 0) {
			res = res * x;
		}
		return res;
	}

}
