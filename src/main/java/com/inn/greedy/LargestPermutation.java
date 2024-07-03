package com.inn.greedy;

/*
https://www.interviewbit.com/problems/largest-permutation/
 */

import java.util.*;

public class LargestPermutation {

    public static void main(String[] args) {
        int[] A = {3, 2, 4, 1, 5};
        int B = 3;
        //System.out.println(Arrays.toString(solve(A, B)));
        A = new int[]{3, 2, 4, 1, 5};
        //System.out.println(Arrays.toString(solve1(A, B)));

        int[][] twoDArray = {{0,30},{5,10},{15,20}};

        int len = twoDArray.length;
        System.out.println(len);
        for(int i=0;i<len;i++){
            System.out.println(Arrays.toString(twoDArray[i]));
        }
        Map<Integer,Integer> map = new TreeMap<>((i1,i2) -> i2.compareTo(i1));
        for(int i=0;i<5;i++){
            map.put(i,i+10);
        }
        System.out.println(map);
    }

    private static int[] solve1(int[] A, int B) {
        Map<Integer, Integer> elementWithIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            elementWithIndex.put(A[i], i);
        }

        int maxElement = A.length;
        int ithIndex = 0;
        while (B > 0) {
            int maxIndex = elementWithIndex.get(maxElement);
            // if max element is not at the correct position than only swap will happen
            if (maxIndex != ithIndex) {
                // swap A[0] with A[maxIndex]
                int temp = A[ithIndex];
                A[ithIndex] = A[maxIndex];
                A[maxIndex] = temp;

                elementWithIndex.put(A[ithIndex], ithIndex);
                elementWithIndex.put(A[maxIndex], maxIndex);
            }

            ithIndex += 1;
            maxElement -= 1;
            B -= 1;
        }
        return A;
    }

    private static int[] solve(int[] A, int B) {
        int length = A.length;
        int n = length;
        int properIndex = 0;
        while (B > 0) {
            // find nth element
            int nthElement = getNthElementIndex(A, n);
            n = n - 1;
            //System.out.println(nthElement);
            // swap A[0] with A[nthElement]
            int temp = A[properIndex];
            A[properIndex] = A[nthElement];
            A[nthElement] = temp;
            B = B - 1;
            properIndex = properIndex + 1;
        }
        return A;
    }

    private static int getNthElementIndex(int[] A, int n) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == n) {
                return i;
            }
        }
        return -1;
    }

}
