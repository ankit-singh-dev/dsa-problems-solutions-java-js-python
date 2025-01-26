package com.inn.greedy;

/*
https://www.geeksforgeeks.org/policemen-catch-thieves/
https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1
 */

import java.util.ArrayList;
import java.util.List;

public class PoliceThiefs {

    public static void main(String[] args) {
        char[] arr = {'P', 'T', 'T', 'P', 'T'};
        int n = arr.length;
        int k = 1;
        System.out.println(catchThieves(arr, n, k));

        arr = new char[]{'P', 'T', 'T', 'P', 'T'};
        System.out.println(catchThievesUsingGreedy(arr, n, k));
    }

    // using greedy approach
    private static int catchThievesUsingGreedy(char arr[], int n, int k) {
        int count = 0;
        List<Integer> policeIndexes = new ArrayList<>();
        List<Integer> thiefsIndexes = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(arr[i] == 'P'){
                policeIndexes.add(i);
            }else if(arr[i] == 'T'){
                thiefsIndexes.add(i);
            }
        }

        int policeIndex = 0;
        int thiefIndex = 0;

        while (policeIndex < policeIndexes.size() && thiefIndex < thiefsIndexes.size()){
            if(Math.abs(policeIndexes.get(policeIndex) - thiefsIndexes.get(thiefIndex)) <= k){
                count++;
                policeIndex++;
                thiefIndex++;
            }else if(policeIndexes.get(policeIndex) < thiefsIndexes.get(thiefIndex)){
                policeIndex++;
            }else{
                thiefIndex++;
            }
        }

        return count;
    }

    // brute force approach
    private static int catchThieves(char arr[], int n, int k) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isThiefCaughtByCurrentPoliceMan = false;
            if (arr[i] == 'P') {
                //police travel backwards
                int howMuchBack = Math.max(i - k, 0);
                for (int back = howMuchBack; back < i; back++) {
                    if (arr[back] == 'T') {
                        //update the caught thief to caught(c)
                        arr[back] = 'C';
                        // current police has caught a thief while travelling backwards
                        isThiefCaughtByCurrentPoliceMan = true;
                        // update count by 1
                        count++;
                        // since a police man can caught only one thief breaking for it
                        break;
                    }
                }

                // police will travel forward only if the current police doesn't caught thief while backwards
                if (!isThiefCaughtByCurrentPoliceMan) {
                    int howMuchForw = Math.min(i + k, n - 1);
                    //police travel forwards
                    for (int forw = i + 1; forw <= howMuchForw; forw++) {
                        if (arr[forw] == 'T') {
                            //update the caught thief to caught(c)
                            arr[forw] = 'C';
                            // current police has caught a thief while travelling forward
                            // update count by 1
                            count++;
                            // since a police man can caught only one thief breaking for it
                            break;
                        }
                    }
                }
            }
        }

        return count;
    }

}
