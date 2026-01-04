package com.inn.twopointers;

/*
https://leetcode.com/problems/backspace-string-compare/
 */

public class BackSpaceStringCmp {

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    // using extra memory ( string builder)
    public static boolean backspaceCompare1(String s, String t) {
        var val1 = getUpdatedStr(s);
        var val2 = getUpdatedStr(t);
        return val1.compareTo(val2) == 0;
    }

    private static StringBuilder getUpdatedStr(String input){
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            if(input.charAt(i) == '#'){
                if(!sb.isEmpty()){
                    sb.deleteCharAt(sb.length()-1);
                }
            }else {
                sb.append(input.charAt(i));
            }
        }
        return sb;
    }

    // using two pointers
    private static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {

            // Process backspaces in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            // Process backspaces in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // Compare characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) return false;
            } else {
                if (i >= 0 || j >= 0) return false;
            }

            i--;
            j--;
        }
        return true;
    }


}