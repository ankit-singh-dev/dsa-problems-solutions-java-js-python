package com.inn.stacks;

/*
https://leetcode.com/problems/next-greater-element-i/
 */

import java.util.*;

public class Leetcode496 {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ans = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterElementMap = new HashMap<>();
        Deque<Integer> nextGreaterElementStack = new ArrayDeque<>();

        // calculate next greater no for each elements of nums2 array
        for (int i = nums2.length - 1; i >= 0; i--) {
            int currentNo = nums2[i];
            while (!nextGreaterElementStack.isEmpty() && nextGreaterElementStack.peek() < nums2[i]) {
                nextGreaterElementStack.pop();
            }

            if (nextGreaterElementStack.isEmpty()) {
                nextGreaterElementMap.put(nums2[i], -1);
            } else {
                nextGreaterElementMap.put(nums2[i], nextGreaterElementStack.peek());
            }
            nextGreaterElementStack.push(currentNo);
        }

        int index = 0;
        for(int no : nums1){
            nums1[index++] = nextGreaterElementMap.get(no);
        }

        return nums1;
    }
}
