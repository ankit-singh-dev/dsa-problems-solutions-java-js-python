package com.inn.slidingwindow;

/*
https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 */

public class MaxSubArrayOfSizeK {

    public static void main(String[] args) {
        int K = 4;
        int[] Arr = {100, 200, 300, 400};

        System.out.println(maximumSumSubarray(K, Arr, Arr.length));
        System.out.println(usingSlidingWindow(K, Arr, Arr.length));
    }

    private static long usingSlidingWindow(int K, int[] Arr, int N) {
        long bestSum = Long.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < K; i++) {
            sum += Arr[i];
        }

        bestSum = Math.max(sum, bestSum);

        for (int i = 1; i < (N - K) + 1; i++) {
            int prevNo = Arr[i-1];
            int nextNo = Arr[i+K-1];

            sum -= prevNo;
            sum += nextNo;

            bestSum = Math.max(sum, bestSum);
        }
        return bestSum;
    }

    // Brute force
    private static long maximumSumSubarray(int K, int[] Arr, int N) {

        long finalMax = Long.MIN_VALUE;
        for (int i = 0; i < N - K + 1; i++) {
            long sum = 0;
            for (int j = i; j < (i + K); j++) {
                sum += Arr[j];
            }
            finalMax = Math.max(sum, finalMax);
        }

        return finalMax;
    }
}
