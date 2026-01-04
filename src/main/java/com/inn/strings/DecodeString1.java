package com.inn.strings;

/*
https://leetcode.com/problems/decode-string/
 */

import java.util.Stack;

public class DecodeString1 {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(String.valueOf(s.charAt(0)));
        StringBuilder str= new StringBuilder();
        for(int i=0;i<s.length();i++){
           
            if(s.charAt(i)=='[' ){

            } else if (s.charAt(i) ==']') {
                for(int j=0;j<n;j++){
                    sb.append(str);
                }
                str= new StringBuilder();
                if(i !=s.length()-1){
                    n=Integer.parseInt(String.valueOf(s.charAt(i+1)));
                }

            } else if (Character.isAlphabetic(s.charAt(i))) {
                str.append(s.charAt(i));;
            }

        }
        return sb.toString();

    }
}
