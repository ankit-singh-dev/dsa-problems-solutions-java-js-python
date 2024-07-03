package com.inn.recursion;

import java.util.Arrays;

public class OccurancesInArrayUsingRecursion {

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 9, 8, 3, 2, 3,6, 4};
        int element = 4;
        System.out.println(firstIndexOfElement(array, element, 0));
        int anotherElement = 6;
        System.out.println(lastIndexOfElement(array, anotherElement, 0));
        int yetAnotherElement = 3;
        System.out.println(Arrays.toString(allIndexesOfElement(array, yetAnotherElement, 0,0)));
    }

    private static int firstIndexOfElement(int[] array, int element, int index) {
        if(index == array.length){
            return -1;
        }
        if (array[index] == element) {
            return index;
        } else {
            return firstIndexOfElement(array, element, index + 1);
        }
    }

    private static int lastIndexOfElement(int[] array, int element, int index) {
        if(index == array.length){
            return -1;
        }
        int requiredIndex = -1;
        if(array[index] == element){
            requiredIndex = index;
        }
        int mayBeIndex = lastIndexOfElement(array, element , index+1);
        if(mayBeIndex == -1 && requiredIndex != -1){
            return requiredIndex;
        }
        return mayBeIndex;
    }

    private static int[] allIndexesOfElement(int[] array, int element, int index, int foundSoFar){
        if(array.length == index){
            return new int[foundSoFar];
        }
        boolean flag = false;
        if(array[index] == element){
            flag = true;
            foundSoFar = foundSoFar + 1;
        }
        int[] indicesArray = allIndexesOfElement(array, element, index + 1, foundSoFar);
        if(flag) {
            indicesArray[--foundSoFar] = index;
        }
        return indicesArray;
    }


}
