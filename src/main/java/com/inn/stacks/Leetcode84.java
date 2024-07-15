package com.inn.stacks;

/*
https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode84 {

    public static void main(String[] args) {
        //int[] heights = {2, 1, 5, 6, 2, 3};
        //int[] heights = {1, 1};
        int[] heights = {4, 2, 0, 3, 2, 4, 3, 4};
        System.out.println(largestRectangleArea(heights));
    }

    private static int largestRectangleArea(int[] heights) {
        int[] nextSmallerToRight = nextSmallerToRight(heights);
        int[] nextSmallerToLeft = nextSmallerToLeft(heights);
        System.out.println(Arrays.toString(nextSmallerToRight));
        System.out.println(Arrays.toString(nextSmallerToLeft));
        int maxRectangleArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            heights[i] = heights[i] * (nextSmallerToRight[i] - nextSmallerToLeft[i] - 1);
            maxRectangleArea = Math.max(maxRectangleArea, heights[i]);
        }

        return maxRectangleArea;
    }

    private static int[] nextSmallerToRight(int[] heights) {
        int[] nextSmallerToRight = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {

            if (heights[i] != 0) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    nextSmallerToRight[i] = heights.length;
                } else {
                    nextSmallerToRight[i] = stack.peek();
                }
            }

            stack.push(i);
        }

        return nextSmallerToRight;
    }

    private static int[] nextSmallerToLeft(int[] heights) {
        int[] nextSmallerToLeft = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextSmallerToLeft[i] = -1;
            } else {
                nextSmallerToLeft[i] = stack.peek();
            }
            stack.push(i);
        }
        return nextSmallerToLeft;
    }

}
