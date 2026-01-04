package com.inn.neetcode150;

/*
https://leetcode.com/problems/valid-anagram/
 */

import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";

        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram1(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

        int[] array = new int[26];

        for(int i=0;i<s.length();i++){
            char firstChar = s.charAt(i);
            char secondChar = t.charAt(i);

            array[firstChar-'a']++;
            array[secondChar-'a']--;
        }

        for(int i=0;i<array.length;i++){
            if(array[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for(char ch : s.toCharArray()){
            int count = charCount.getOrDefault(ch, 0);
            charCount.put(ch, count+1);
        }


        for(char ch : t.toCharArray()){
            if(!charCount.containsKey(ch)){
                return false;
            }
            int count = charCount.get(ch);
            charCount.put(ch, count-1);

            count = charCount.get(ch);
            if(count == 0){
                charCount.remove(ch);
            }
        }
        return true;
    }

}
