package com.inn.recursion;

public class MaxElementInArray {

    public static void main(String[] args) {
        int[] array = {10, 50, 5, 60, 90, 4, 57};
        System.out.println(maxInArray(array, 0));
    }

    private static int maxInArray(int[] array, int index) {
        if(array.length == 0){
            return -1;
        }
        if((index+1) == array.length){
            return array[index];
        }
        int currentElement = array[index];
        int maxFromSubArray = maxInArray(array, index+1);
        return Math.max(currentElement, maxFromSubArray);
    }
}
