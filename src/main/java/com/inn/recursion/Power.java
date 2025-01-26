package com.inn.recursion;

public class Power {

    public static void main(String[] args) {
        int x = 5;
        int n = 6;
        System.out.println(power(x, n));
        System.out.println(usingLogTime(x, n));
    }

    private static int power(int x, int n){
        if(n == 0) return 1;
        int res = power(x, n-1);
        return x * res;
    }

    private static int usingLogTime(int x, int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }
        int res1 = power(x, n/2);
        int res2 = power(x, n/2);

        if(n % 2 == 0){
            return res1 * res2;
        }else{
            return x*res1*res2;
        }
    }
}
