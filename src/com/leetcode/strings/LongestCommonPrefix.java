package com.leetcode.strings;

/*
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		String longestCommonPrefix = "";

		if (strs == null || strs.length == 0) {
			return longestCommonPrefix;
		}

		for (int i = 0; i < strs[0].length(); i++) {

			char c = strs[0].charAt(i);

			for (int j = 1; j < strs.length; j++) {

				if (strs[j].length() > i && strs[j].charAt(i) == c) {
					continue;
				}
				return longestCommonPrefix;
			}
			longestCommonPrefix += c;
		}
		return longestCommonPrefix;
	}
}
