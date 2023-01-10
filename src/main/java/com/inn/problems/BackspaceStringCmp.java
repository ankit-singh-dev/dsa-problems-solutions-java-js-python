package com.inn.problems;

public class BackspaceStringCmp {

	public static void main(String[] args) {
		System.out.print("Hello");
	}

	private static boolean backspaceCompare(String s, String t) {
		String out1 = getStringValueAfterRemovingChar(s);
		String out2 = getStringValueAfterRemovingChar(t);
		return out1.equals(out2);
	}

	private static String getStringValueAfterRemovingChar(String input) {
		char[] charArray = new char[input.length()];
		int pointer1 = 0;
		for (char ch : input.toCharArray()) {
			if (ch != '#') {
				charArray[pointer1] = ch;
				pointer1++;
			} else {
				if (pointer1 > 0) {
					pointer1--;
					charArray[pointer1] = '#';
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (char ch : charArray) {
			if (Character.isAlphabetic(ch)) {
				result.append(ch);
			}
		}

		return result.toString();
	}

}
