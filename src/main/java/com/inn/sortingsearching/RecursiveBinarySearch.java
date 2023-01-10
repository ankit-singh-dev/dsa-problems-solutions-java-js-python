package com.inn.sortingsearching;

public class RecursiveBinarySearch {

	public static void main(String[] args) {
		int[] array = {12,24,36,48,60};
		int element = 24;
		int resultIndex = findElement(array, element,0,array.length-1);
		if(resultIndex == -1) {
			System.out.println("Element "+ element +" is not present");
		}else {
			System.out.println("Element "+element+" present at index "+resultIndex);
		}
	}

	private static int findElement(int[] array,int element,int start,int end) {
		if(array.length == 0 || end < start) {
			return -1;
		}
		int mid = start + (end-start)/2;
		if(array[mid] == element) {
			return mid;
		}
		if(array[mid] < element) {
			return findElement(array, element, mid+1, end);
		}else {
			return findElement(array, element, start, mid-1);
		}
	}
}
