package com.inn.linkedlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1 {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pp = new PriorityQueue<>((i1, i2) -> i2-i1);
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0;i<k;i++){
            pp.add(nums[i]);
        }
        System.out.println(pp.size());
        res[0] = pp.peek();

        for(int i=1;i<(n-k)+1;i++){
            int prev = nums[i-1];
            int next = nums[i+k-1];

            pp.remove(prev);
            pp.add(next);

            System.out.println(pp.size());

            res[i] = pp.peek();
        }
        return res;
    }

    public static boolean isAnagram(String s, String t) {
        int[] charArray = new int[26];

        for(char ch : s.toCharArray()){
            int index = ch - 97;
            charArray[index]++;
        }


        for(char ch : t.toCharArray()){
            int index = ch - 97;
            if(charArray[index] == 0){
                return false;
            }
            charArray[index]--;
        }

        return true;
    }



    public static boolean solution(String[] B) {
        // Implement your solution here
        // convert it to 2-D matrix
        String[][] twoD = new String[B.length][B[0].length()];

        int x = -1;
        int y = -1;
        for (int i = 0; i < B.length; i++) {
            String[] res = new String[B[i].length()];
            int index = 0;
            for (char ch : B[i].toCharArray()) {
                if(ch == 'A'){
                    // got assaisian
                    x = i;
                    y = index;
                }else if(ch == 'v'){

                }
                res[index++] = String.valueOf(ch);
            }
            twoD[i] = res;
        }


        return false;
    }
}

// custom arraylist add() get()

class CustomArrayList{

    private int defaultCapacity = 100;
    private Integer[] integers;

    private int index = 0;

    public CustomArrayList(){
        integers = new Integer[defaultCapacity];
    }

    public boolean add(int no){
        integers[index++] = no;
        return true;
    }

    public int get(int index){
        return integers[index];
    }

}