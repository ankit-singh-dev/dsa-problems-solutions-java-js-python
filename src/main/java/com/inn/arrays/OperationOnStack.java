package com.inn.arrays;

import java.util.Stack;

/*
 *https://brainly.in/question/8173751 
 */

public class OperationOnStack {

	public static void main(String[] args) {
		String inputStr = "3 DUP 5 - -";
		System.out.println(solution(inputStr));
	}

	public static int solution(String S) {
		// Implement your solution here
		Stack<Integer> integers = new Stack<>();

		String[] inputs = S.split(" ");

		for (String input : inputs) {
			if (input.equalsIgnoreCase("+")) {
				if(integers.isEmpty()) {
					return -1;
				}
				int lastElement = integers.pop();
				if(integers.isEmpty()) {
					return -1;
				}
				int lastSecondElement = integers.pop();
				int newNo = lastElement + lastSecondElement;
				integers.push(newNo);
			} else if (input.equalsIgnoreCase("-")) {
				System.out.println(integers);
				if(integers.isEmpty()) {
					return -1;
				}
				int lastElement = integers.pop();
				if(integers.isEmpty()) {
					return -1;
				}
				int lastSecondElement = integers.pop();
				int newNo = lastElement - lastSecondElement;
				integers.push(newNo);
			} else if (input.equalsIgnoreCase("POP")) {
				if(integers.isEmpty()) {
					return -1;
				}
				integers.pop();
			} else if (input.equalsIgnoreCase("DUP")) {
				if(integers.isEmpty()) {
					return -1;
				}
				int no = integers.peek();
				integers.push(no);
			} else {
				integers.push(Integer.valueOf(input));
			}
		}

		return integers.peek();
	}

}
