package com.inn.bitmanipulation;

public class BitsOnOrOff {
    public static void main(String[] args) {
        int no = 9;
        int bitIndex = 3;
        System.out.println(findBitIsOnOrOffUsingOr(no, bitIndex));
        System.out.println(findBitIsOnOrOffUsingAnd(no, bitIndex));
    }

    private static String findBitIsOnOrOffUsingAnd(int no, int bitIndex) {
        int leftShift = (1 << bitIndex);
        int res = (no & leftShift);
        if(res == 0){
            return "OFF";
        }else{
            return "ON";
        }
    }

    private static String findBitIsOnOrOffUsingOr(int no, int bitIndex){
        int leftShift = (1 << bitIndex);
        int res = (no | leftShift);
        if(res == no){
            return "ON";
        }else{
            return "OFF";
        }
    }
}
