package com.inn.slidingwindow;

/*
https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FirstNegativeInSizeK {

    public static void main(String[] args) {
        long[] A = {-8, 2, 3, -6, 10};
        int N = A.length;
        int K = 2;

        System.out.println(Arrays.toString(printFirstNegativeInteger(A, N, K)));
        System.out.println(Arrays.toString(slidingWindow(A, N, K)));
    }

    // using sliding window technique
    private static long[] slidingWindow(long A[], int N, int K) {
        long[] res = new long[N - K + 1];
        Deque<Long> queue = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                queue.offer(A[i]);
            }
        }
        if (!queue.isEmpty()) {
            res[0] = queue.peek();
        }

        for (int i = 1; i < (N - K) + 1; i++) {
            long prev = A[i-1];
            long next = A[i+K-1];

            if(prev < 0) {
                queue.remove(prev);
            }
            if(next < 0){
                queue.offer(next);
            }
            if (!queue.isEmpty()){
                res[i] = queue.peek();
            }

        }
        return res;
    }


    // brute force
    private static long[] printFirstNegativeInteger(long A[], int N, int K) {
        long[] res = new long[N - K + 1];

        for (int i = 0; i < N - K + 1; i++) {
            res[i] = 0;
            for (int j = i; j < (i + K); j++) {
                if (A[j] < 0) {
                    res[i] = A[j];
                    break;
                }
            }
        }
        return res;
    }
}
