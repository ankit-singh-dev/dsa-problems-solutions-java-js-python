package com.inn.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NearestGreatToLeft {

    public static void main(String[] args) {
        //int[] array = {1, 3, 2, 4};
        int[] array = {1, 3, 0, 0, 1, 2, 4};
        //int[] array = {4, 5, 2, 25};
        //int[] array = {13, 7, 6, 12};
        System.out.println(Arrays.toString(bruteForceApproach(array)));

        //array = new int[]{1, 3, 2, 4};
        array = new int[]{1, 3, 0, 0, 1, 2, 4};
        //array = new int[]{4, 5, 2, 25};
        //array = new int[]{13, 7, 6, 12};
        System.out.println(Arrays.toString(usingStack(array)));
    }

    private static int[] usingStack(int[] array) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            int currentNo = array[i];
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                array[i] = -1;
            } else {
                array[i] = stack.peek();
            }
            stack.push(currentNo);
        }
        return array;
    }

    private static int[] bruteForceApproach(int[] array) {
        int len = array.length;
        int[] ans = new int[len];
        ans[0] = -1;
        for (int i = 1; i < len; i++) {
            boolean isBreakExecuted = false;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[i]) {
                    ans[i] = array[j];
                    isBreakExecuted = true;
                    break;
                }
            }
            if (!isBreakExecuted) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
