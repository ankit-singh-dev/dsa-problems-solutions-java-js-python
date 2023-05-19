package com.inn.twopointers;

import java.util.ArrayList;

/*
 * https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
 */

public class MergeTwoSortedList {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(-5);
		//a.add(3);
		//a.add(5);
		//a.add(7);
		
		ArrayList<Integer> b = new ArrayList<>();
		b.add(-5);
		//b.add(4);
		//b.add(6);
		//b.add(8);
		
		merge(a, b);
	}

	private static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int i = 0;
		int j = 0;
		while(i < a.size() && j < b.size()) {
			if(a.get(i) > b.get(j)) {
				a.add(i, b.get(j));
				j++;
			}else if(a.get(i) < b.get(j)) {
				i++;
			}else {
				a.add(i,b.get(j));
				i++;
				j++;
			}
		}
		while(j < b.size()) {
			a.add(i,b.get(j));
			j++;
		}
		System.out.println(a);
	}

}
