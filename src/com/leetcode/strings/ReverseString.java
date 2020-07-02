package com.leetcode.strings;

/*
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

	public void reverseString(char[] s) {

		int len = s.length;

		int low = 0, high = len - 1;

		while (low < high) {
			char temp = s[low];
			s[low] = s[high];
			s[high] = temp;
			low++;
			high--;
		}
	}
}
