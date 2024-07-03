package com.inn.recursion;

public class DisplayArrayUsingRecursion {

    public static void main(String[] args) {
        int[] array = {10,20,30,40,50};
        //displayArray(array, 0);
        displayArrayInReverse(array, 0);
    }

    private static void displayArray(int[] array, int index){
        if(index == array.length){
            return;
        }
        System.out.println(array[index]);
        displayArray(array, index + 1);
    }

    private static void displayArrayInReverse(int[] array, int index){
        if(index == array.length){
            return;
        }
        int currentElement = array[index];
        displayArrayInReverse(array, index+1);
        System.out.println(currentElement);
    }
}
