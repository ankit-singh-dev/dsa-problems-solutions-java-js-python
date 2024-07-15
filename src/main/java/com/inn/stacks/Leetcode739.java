package com.inn.stacks;

/*
https://leetcode.com/problems/daily-temperatures/description/
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode739 {

    public static void main(String[] args) {
        int[] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] res1 = bruteForce(temperatures);

        temperatures = new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] res2 = dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> integersStack = new ArrayDeque<>();
        int len = temperatures.length;
        int[] ans = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!integersStack.isEmpty() && temperatures[integersStack.peek()] <= temperatures[i]) {
                integersStack.pop();
            }
            if (integersStack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = (integersStack.peek()) - i;
            }
            integersStack.push(i);
        }
        return ans;
    }

    private static int[] bruteForce(int[] temperatures) {
        int len = temperatures.length;

        for (int i = 0; i < len; i++) {
            int currentNo = temperatures[i];
            temperatures[i] = 0;
            for (int j = i + 1; j < len; j++) {
                if (currentNo < temperatures[j]) {
                    temperatures[i] = (j - i);
                    break;
                }
            }
        }
        return temperatures;
    }
}
