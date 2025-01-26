package com.inn.greedy;

import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        List<String> stringList = List.of("act","ball","cat","llab","opt","pat","pot","tap","samsung","tac");
        System.out.println(getAnagrams(stringList));
    }

    private static Map<String, Integer> getAnagrams(List<String> stringList){

        Set<Integer> set = new HashSet<>();

        Map<String, Integer> res = new LinkedHashMap<>();
        for(int i=0;i<stringList.size();i++){ // o(n)
            String s = stringList.get(i);
            int count = 1;

            for(int j=i+1;j<stringList.size();j++){ // o(n log n)
                if(i != j){
                    Map<Character, Integer> map = getCount(s);
                    boolean isBreak = false;
                    if(s.length() == stringList.get(j).length()){ // o(s.length)
                        for(char ch : stringList.get(j).toCharArray()){
                            if(map.containsKey(ch)){
                                int cnt = map.get(ch);
                                map.put(ch, cnt-1);
                                if(map.get(ch) == 0){
                                    map.remove(ch);
                                }
                            }else{
                                isBreak = true;
                                break;
                            }
                        }
                    }
                    if(!isBreak && map.isEmpty()){
                        res.put(s, count+1);
                        count++;
                    }
                }
            }
        }

        return res;
    }

    private static Map<Character, Integer> getCount(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            int existingCount = map.getOrDefault(ch, 0);
            map.put(ch, existingCount+1);
        }
        return map;
    }
}
