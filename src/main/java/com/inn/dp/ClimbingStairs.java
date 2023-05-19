package com.inn.dp;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(getStairsCountUsingRecursion(n));
		System.out.println(getStairsCountUsingDp(n,new int[10]));
	}

	private static int getStairsCountUsingDp(int n,int[] clibingPaths) {

		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		if(clibingPaths[n] != 0) {
			return clibingPaths[n];
		}

		System.out.println("Hello Dp" + n);
		int path1 = getStairsCountUsingDp(n - 1,clibingPaths);
		int path2 = getStairsCountUsingDp(n - 2,clibingPaths);
		int path3 = getStairsCountUsingDp(n - 3,clibingPaths);

		int fullPath =  path1 + path2 + path3;
		clibingPaths[n] = fullPath;
		return fullPath;
	}

	private static int getStairsCountUsingRecursion(int n) {

		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}

		System.out.println("Hello " + n);
		int path1 = getStairsCountUsingRecursion(n - 1);
		int path2 = getStairsCountUsingRecursion(n - 2);
		int path3 = getStairsCountUsingRecursion(n - 3);

		return path1 + path2 + path3;
	}

}
