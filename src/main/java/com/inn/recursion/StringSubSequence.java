package com.inn.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringSubSequence {

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(getSubSequence(str));
    }
    private static List<String> getSubSequence(String str){
        if(str.isEmpty()){
            List<String> hh = new ArrayList<>();
            hh.add("");
            return hh;
        }
        char ch = str.charAt(0);
        String restOfString = str.substring(1);

        List<String> restofStringSubSequence = getSubSequence(restOfString);
        List<String> myResult = new ArrayList<>();
        for(String s : restofStringSubSequence){
            myResult.add(""+s);
            myResult.add(ch + s);
        }

        return myResult;
    }
}
