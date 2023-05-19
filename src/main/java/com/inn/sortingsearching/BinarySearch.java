package com.inn.sortingsearching;

/*
 * https://leetcode.com/problems/binary-search/description/
 */

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] array = {12,24,36,48,60};
		int element = 24;
		int resultIndex = findElement(array, element);
		if(resultIndex == -1) {
			System.out.println("Element "+ element +" is not present");
		}else {
			System.out.println("Element "+element+" present at index "+resultIndex);
		}
	}
	
	
	private static int findElement(int[] array,int element) {
		if(array.length == 0) {
			return -1;
		}
		
		int length = array.length;
		int start = 0;
		int end = length-1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(array[mid] == element) {
				return mid;
			}else if(array[mid] < element) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		return -1;
	}
	
}
