package com.inn.neetcode150;

/*
https://leetcode.com/problems/group-anagrams/description/
 */

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramGroup = new HashMap<>();

        int[] array = new int[26];

        for (String str : strs) {
            Arrays.fill(array, 0);

            for (char ch : str.toCharArray()) {
                array[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(array[i]);
            }
            System.out.println(sb);

            List<String> anagrams = anagramGroup.get(sb.toString());
            if (Objects.isNull(anagrams)) {
                anagrams = new ArrayList<>();
                anagrams.add(str);

                anagramGroup.put(sb.toString(), anagrams);
            } else {
                anagrams.add(str);
            }
        }

        System.out.println(anagramGroup);
        return new ArrayList<>(anagramGroup.values());
    }
}

