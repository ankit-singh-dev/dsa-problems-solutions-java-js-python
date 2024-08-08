package com.inn.arrays;

/*
i/p = {0,3,1,0,4,5,2,0}
o/p = [4,11]

i/p = {0,1,0,3,0,2,2,0}
o/p = [1,3,4s]
*/

import java.util.ArrayList;
import java.util.List;

public class AddNumbersInBetweenZeros {

    public static void main(String[] args) {
        //int[] array = {3, 0, 0, 0, 0, 3, 1, 0, 4, 5, 2, 0};
        int[] array = {0, 1, 0, 3, 0, 2, 2, 0};
        System.out.println(getSumsInBetweenZero(array));
    }

    private static List<Integer> getSumsInBetweenZero(int[] array) {
        List<Integer> integerList = new ArrayList<>();
        int i = 0;
        int j = i + 1;
        int sum = 0;

        while (i < array.length && j < array.length) {
            if (array[i] > 0) {
                i++;
                continue;
            }

            // meet the other end of 0
            if (array[j] == 0) {
                // if adjacent elements are zero than keeps on changing pointers
                if ((j - i) > 1) {
                    integerList.add(sum);
                    sum = 0;
                }
                i = j;
                j = j + 1;
            } else {
                // looking for other end
                sum += array[j];
                j++;
            }
        }
        return integerList;
    }

}
