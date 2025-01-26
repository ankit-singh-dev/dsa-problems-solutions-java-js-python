package com.inn.greedy;

/*
https://leetcode.com/problems/lemonade-change/description/
https://www.geeksforgeeks.org/problems/lemonade-change/1
 */

public class LemonadeChange {

    public static void main(String[] args) {

    }

    private static boolean lemonadeChange(int[] bills) {

        // for storing 5, 10 , 15 counts
        int[] changes = new int[3];

        for(int bill : bills){
            if(bill == 5){
                changes[0]++;
            }else if(bill == 10){
                changes[1]++;
                // for 10$ bill you should have at least 5$ change
                if(changes[0] > 0){
                    changes[0]--;
                }else{
                    return false;
                }
            }else{
                changes[2]++;
                /*
                 for 20$ bill you should have at least one 10$ and one 5$ or
                 for 20$ bill you should have at least 3 5$
                */
                if (changes[1] > 0 && changes[0] > 0){
                    changes[1]--;
                    changes[0]--;
                }else if(changes[0] > 2){
                    changes[0] = changes[0]-3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
