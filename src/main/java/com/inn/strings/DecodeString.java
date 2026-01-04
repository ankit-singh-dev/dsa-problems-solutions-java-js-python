package com.inn.strings;

/*
https://leetcode.com/problems/decode-string/
 */

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch : s.toCharArray()){
            stk.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder innerSb = new StringBuilder();
        while(!stk.isEmpty()){
            char head = stk.pop();
            if(head == ']'){
                innerSb.setLength(0);
            }else if(head == '['){
                innerSb.reverse();
            } else if(Character.isLetter(head)){
                innerSb.append(head); // cb
            } else if(Character.isDigit(head)){
                int times = head-'0';
                String val = innerSb.toString();
                innerSb.setLength(0);
                innerSb.append(val.repeat(Math.max(0, times)));
                sb.append(innerSb);
            }
        }
        return sb.toString();
    }
}
