package com.leetcode.strings;

/*
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LastWordLength {

	public int lengthOfLastWord(String s) {

		String[] str = s.split("\\s+");

		return str.length > 0 ? str[str.length - 1].length() : 0;
	}
}
