package com.inn.greedy;

/*
https://www.geeksforgeeks.org/problems/shortest-job-first/0
 */

import java.util.Arrays;

public class ShortestJobFirst {

    public static void main(String[] args) {
        int[] bt = {4,3,7,1,2};
        System.out.println(solve(bt));
    }

    private static int solve(int bt[]) {
        Arrays.sort(bt);
        // total process time
        int processTime = 0;

        // time taken by each process
        int timeTaken = 0;

        for (int j : bt) {
            // process time of process j will be last process ending time + last process time taken
            processTime = processTime + timeTaken;

            // time taken bt process j will be last process ending time + current process time
            timeTaken = timeTaken + j;
        }

        return processTime/bt.length;

    }

}
