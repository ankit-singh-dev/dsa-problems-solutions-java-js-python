package com.inn.stacks;

/*
https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
https://www.geeksforgeeks.org/the-stock-span-problem/
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StockSpan {

    public static void main(String[] args) {
        //int[] stocks = {100, 80, 60, 70, 60, 75, 85};
        //int[] stocks = {10, 4, 5, 90, 120, 80};
        int[] stocks = {90, 40, 20, 30, 80, 60, 100};
        System.out.println(Arrays.toString(stockSpanUsingBruteForce(stocks)));
        System.out.println(Arrays.toString(stockSpanProblemUsingStock(stocks)));
    }

    private static int[] stockSpanProblemUsingStock(int[] stocks) {
        int[] ansArray = new int[stocks.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < stocks.length; i++) {
            int ans = 1;
            boolean isStackHasBeenPoped = false;
            while(!stack.isEmpty()){
                if(stocks[stack.peek()] > stocks[i]){
                    ans = i - (stack.peek());
                    break;
                }
                stack.pop();
                if(stack.isEmpty()){
                    isStackHasBeenPoped = true;
                }
            }
            if(isStackHasBeenPoped && stack.isEmpty()){
                ansArray[i] = i+1;
            }else {
                ansArray[i] = ans;
            }

            stack.push(i);
        }
        return ansArray;
    }

    private static int[] stockSpanUsingBruteForce(int[] stocks) {
        int len = stocks.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            int stockSpanCnt = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (stocks[j] > stocks[i]) break;
                stockSpanCnt++;
            }
            ans[i] = stockSpanCnt;
        }

        return ans;
    }

}
