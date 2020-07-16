package com.leetcode.utils;

public class ArrayUtils {

	private static final String SPACE = " ";

	public static void print(String[] arr) {
		if (arr != null) {
			for (String s : arr) {
				System.out.print(s + SPACE);
			}
		}
		System.out.println();
	}

	public static void print(Integer[] arr) {
		if (arr != null) {
			for (Integer s : arr) {
				System.out.print(s + SPACE);
			}
		}
		System.out.println();
	}
	
	public static void print(int[] arr) {
		if (arr != null) {
			for (Integer s : arr) {
				System.out.print(s + SPACE);
			}
		}
		System.out.println();
	}
	
	public static void print(char[] arr) {
		if (arr != null) {
			for (char s : arr) {
				System.out.print(s + SPACE);
			}
		}
		System.out.println();
	}

	public static <T> void print(T[] arr) {
		if (arr != null) {
			for (T a : arr) {
				System.out.print(a + SPACE);
			}
		}
		System.out.println();
	}
}
