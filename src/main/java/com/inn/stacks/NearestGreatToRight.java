package com.inn.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreatToRight {

    public static void main(String[] args) {
        //int[] array = {1, 3, 2, 4};
        //int[] array = {1, 3, 0, 0, 1, 2, 4};
        //int[] array = {4, 5, 2, 25};
        int[] array = {13 , 7, 6 , 12};
        System.out.println(Arrays.toString(nearestGreatestToRight(array)));

        //array = new int[]{1,3,2,4};
        //array = new int[]{1, 3, 0, 0, 1, 2, 4};
        //array = new int[]{4, 5, 2, 25};
        array = new int[]{13 , 7, 6 , 12};
        System.out.println(Arrays.toString(usingStack(array)));

        array = new int[]{13 , 7, 6 , 12};
        System.out.println(Arrays.toString(usingMonotonicStack(array)));

    }

    private static int[] usingMonotonicStack(int[] array){
        Stack<Integer> stacks = new Stack<>();
        for (int i = array.length - 1; i >= 0; i--) {
            int requiredNo = array[i];
            // maintaining montonic stack
            while(!stacks.isEmpty() && stacks.peek() < array[i]){
                stacks.pop();
            }
            if(stacks.isEmpty()){
                array[i] = -1;
            }else{
                array[i] = stacks.peek();
            }
            stacks.push(requiredNo);
        }
        return array;
    }

    private static int[] usingStack(int[] array) {
        Stack<Integer> stacks = new Stack<>();
        int len = array.length;

        for (int i = len - 1; i >= 0; i--) {
            int indexNo = array[i];
            if (stacks.isEmpty()) {
                array[i] = -1;
            } else {
                while (!stacks.isEmpty()) {
                    int requiredNo = stacks.peek();
                    if (requiredNo > array[i]) {
                        array[i] = requiredNo;
                        break;
                    } else {
                        stacks.pop();
                    }
                }
                if(stacks.isEmpty()){
                    array[i] = -1;
                }
            }
            stacks.push(indexNo);
        }
        return array;
    }

    /*
    time complexity : O(n^2)
    space complexity : O(n)
     */
    private static int[] nearestGreatestToRight(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int greatestToRight = -1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    greatestToRight = array[j];
                    break;
                }
            }
            array[i] = greatestToRight;
        }
        return array;
    }
}
