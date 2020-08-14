package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/*
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {

	/*
	 * Time: O(N) Space: O(N)
	 */
	public int longestPalindrome(String s) {

		Map<Character, Integer> map = new HashMap<>();
		int palindromeLength = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);

			if (map.get(c) % 2 == 0) {
				map.remove(c);
				palindromeLength += 2;
			}
		}

		if (map.size() > 0) {
			palindromeLength++;
		}
		return palindromeLength;
	}
}
