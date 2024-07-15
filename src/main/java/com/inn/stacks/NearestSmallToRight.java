package com.inn.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NearestSmallToRight {

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(bruteForceApproach(array)));

        array = new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(usingStack(array)));
    }

    private static int[] usingStack(int[] array) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > array[i]){
                stack.pop();
            }
            int currentNo = array[i];
            if(stack.isEmpty()){
                array[i] = -1;
            }else{
                array[i] = stack.peek();
            }
            stack.push(currentNo);
        }
        return array;
    }

    private static int[] bruteForceApproach(int[] array) {
        int len = array.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            boolean isLoopBreak = false;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[i]) {
                    ans[i] = array[j];
                    isLoopBreak = true;
                    break;
                }
            }
            if (!isLoopBreak) {
                ans[i] = -1;
            }
        }
        return ans;
    }

}
