package com.inn.bitmanipulation;

/*
https://yuminlee2.medium.com/brian-kernighans-algorithm-count-set-bits-in-a-number-18ab05edca93#1844
 */

public class Leetcode191 {
    public static void main(String[] args) {
        int n = 9;
        //int i = 6;
        System.out.println(countSetBits(n ));
        System.out.println(kernighanAlgo(n));
        System.out.println(anotherApproach(n));
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            int res = n & 1;
            count += res;
            n = n >> 1;
        }
        return count;
    }

    /*
    https://www.youtube.com/watch?v=I475waWiTK4&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=3
    The idea is to calculate right most set bit and subtract the bit from the number n
    this will continue until the number n becomes 0
     */
    private static int kernighanAlgo(int n){
        int count = 0;
        while(n > 0){
            // calculate right most set bit
            int rmsb = (n & -n);
            // remove the right most set bit
            n = n - rmsb;
            count++;
        }
        return count;
    }

    /*
    The idea is to subtract n-1 from n and perform & operation between n and n-1 thus clearing the right most set bit
    This will continue until the number n becomes 0
     */
    private static int anotherApproach(int n){
        int count = 0;
        while (n > 0){
            n = (n & (n-1));
            count++;
        }
        return count;
    }
}
