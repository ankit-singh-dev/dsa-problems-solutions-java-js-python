package com.inn.arrays;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


@FunctionalInterface
interface ThrowingFunction<T,R,E extends Exception>{
	
	R apply(T fileName) throws E;
	
	static <T> Function<T, T> quiet() {
		return null;
	}
}


public class Test {

	private static final int MONTH_SHIFT = -1;
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		for(int i=0;i<=100000;i++) {
			for(int j=0;j<=1000000;j++) {
				for(int z=0;z<=10000000;z++) {
					
				}
			}
		}
        long end = System.currentTimeMillis();
        System.out.println("Counting to 10000000 takes " +
                (end - start) + "ms");
		
//		String s1="abc";
//		String s2="abc";
//		System.out.println("s1 == s2 " + s1 == s2);
//		
//		Function.identity();
//		Date date = create(2014, 10, 10);
		//System.out.println(changeToMidnight(date, true));
		//System.out.println(changeToMidnight(date, false));
		
		//System.out.println(breakingString("STR2333STR3STR5"));
	}
	
	private static String breakingString(String str) {
		StringBuilder builder = new StringBuilder();
		boolean isNoFound = false;
		for(char ch : str.toCharArray()) {
			if(Character.isDigit(ch)) {
				isNoFound = true;
				builder.append(ch);
			}else {
				if(isNoFound) {
					builder.append(",");
					isNoFound = false;
				}
				builder.append(ch);
			}
		}
		return builder.toString();
	}

	public static Date changeToMidnight(Date date, boolean up) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, up ? 1 : -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date create(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month + MONTH_SHIFT);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

	private static void sss() {
		// 10
		int[] nums = { 10, 5, 20, 20, 4, 10 };
		// highest no => 20

		int greatest = nums[0]; // 20
		for (int no : nums) {
			if (no > greatest) {
				greatest = no;
			}
		}

		int secondGreatest = nums[0];
		for (int no : nums) {
			if (no < greatest && no > secondGreatest) {
				secondGreatest = no;
			}
		}
		System.out.println(secondGreatest);

	}

	private static String getStringName() {
		Supplier<String> supplier = () -> "Ankit Singh";
		return supplier.get();
	}

}
