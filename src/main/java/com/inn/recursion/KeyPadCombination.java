package com.inn.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KeyPadCombination {

    public static void main(String[] args) {
        String keyPadValue = "23";
        System.out.println(getKeyPadCombination(keyPadValue));
    }

    private static List<String> getKeyPadCombination(String keyPadValue){
        // base case
        if(keyPadValue.isEmpty()){
            return new ArrayList<>();
        }else if(keyPadValue.length() == 1){
            String keyyys = getKeyPadValues(keyPadValue.substring(0));
            List<String> res = new ArrayList<>();
            for(char aa : keyyys.toCharArray()){
                res.add(""+aa);
            }
            return res;
        }

        char ch = keyPadValue.charAt(0);
        String restOfKeyPad = keyPadValue.substring(1);

        List<String> keyPadComb = getKeyPadCombination(restOfKeyPad);
        List<String> totalKeyComb = new ArrayList<>();
        String keyPadValues = getKeyPadValues(String.valueOf(ch));
        for(char char1 : keyPadValues.toCharArray()){
            for(String aa : keyPadComb){
                totalKeyComb.add(char1 + aa);
            }
        }

        return totalKeyComb;
    }

    private static String getKeyPadValues(String keyValue){
        return Map.ofEntries(Map.entry("1","abc"),
                Map.entry("2","def"),
                Map.entry("3","ghi"),
                Map.entry("4","jkl"),
                Map.entry("5","mnop"),
                Map.entry("6","qrst"),
                Map.entry("7","uv"),
                Map.entry("8","wxyz"),
                Map.entry("9",".;"),
                Map.entry("0","?!")).get(keyValue);
    }
}
