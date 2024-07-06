package com.inn.bitmanipulation;

public class CountSetBits {
    public static void main(String[] args) {
        int i = 9;
        //int i = 6;
        System.out.println(countSetBits(i));
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
}
