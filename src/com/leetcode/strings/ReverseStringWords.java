package com.leetcode.strings;

/*
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseStringWords {

	public String reverseWords(String s) {

		s = s.trim();
		String[] str = s.split("\\s+");

		int len = str.length;

		int low = 0;
		int high = len - 1;

		while (low < high) {
			String temp = str[low];
			str[low] = str[high];
			str[high] = temp;
			low++;
			high--;
		}
		return String.join(" ", str);
	}
}
