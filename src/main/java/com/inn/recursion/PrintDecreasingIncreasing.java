package com.inn.recursion;

/*
expected input and output
input: n= 5
output: 5,4,3,2,1,1,2,3,4,5
 */

public class PrintDecreasingIncreasing {

    public static void main(String[] args) {
        printDescInc(6);
    }

    private static void printDescInc(int n){
        if(n == 0) return;
        System.out.println(n);
        printDescInc(n-1);
        System.out.println(n);
    }
}
