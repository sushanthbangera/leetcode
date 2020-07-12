package com.leetcode.strings;

/*
 * 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/
 */
public class ReverseKChars {

	public String reverseStr(String s, int k) {

		if (s == null || s.length() == 0 || k == 0)
			return s;

		int len = s.length();
		StringBuilder result = new StringBuilder();
		boolean reverse = true;

		for (int i = 0; i < len; i = i + k) {
			int end = (len - i) > k ? i + k : len;
			String sr = s.substring(i, end);
			if (reverse) {
				result.append(new StringBuilder(sr).reverse());
			} else {
				result.append(sr);
			}
			reverse = !reverse;
		}
		return result.toString();
	}
}
