package com.leetcode.strings;

/*
 * 557. Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWords {

	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return s;

		String[] str = s.split("\\s+");
		int len = str.length;

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < len; i++) {
			String rev = reverseWord(str[i]);
			result.append(rev).append(" ");
		}
		return result.toString().trim();
	}

	private String reverseWord(String word) {
		int len = word.length();
		int low = 0, high = len - 1;
		char[] w = word.toCharArray();

		while (low < high) {
			char temp = w[low];
			w[low] = w[high];
			w[high] = temp;
			low++;
			high--;
		}
		return new String(w);
	}
}
