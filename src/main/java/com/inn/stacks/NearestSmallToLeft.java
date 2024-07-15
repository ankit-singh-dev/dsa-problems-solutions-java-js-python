package com.inn.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 */
public class NearestSmallToLeft {

    public static void main(String[] args) {
        int[] array = {1, 6, 4, 10, 2, 5};
        //int[] array = {1, 3, 0, 2, 5};
        System.out.println(Arrays.toString(bruteForceApparoach(array)));

        array = new int[]{1, 6, 4, 10, 2, 5};
        //array = new int[]{1, 3, 0, 2, 5};
        System.out.println(Arrays.toString(usingStack(array)));
    }

    private static int[] usingStack(int[] array) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            int currentNo = array[i];
            while (!stack.isEmpty() && stack.peek() >= array[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                array[i] = -1;
            }else{
                array[i] = stack.peek();
            }
            stack.push(currentNo);
        }

        return array;
    }

    private static int[] bruteForceApparoach(int[] array) {
        int len = array.length;
        int[] ans = new int[len];
        ans[0] = -1;
        for (int i = 1; i < len; i++) {
            boolean isLoopBreak = false;
            for (int j = i - 1; j >= 0; j--) {
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
