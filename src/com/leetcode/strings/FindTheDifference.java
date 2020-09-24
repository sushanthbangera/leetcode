package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/*
 * 389. Find the Difference
 * 
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindTheDifference {

	/*
	 * Time: O(m + n)  Space: O(m)
	 * m - length of letter s and n - length of letter t
	 */
	public char findTheDifference(String s, String t) {
		Map<Character, Integer> sMap = new HashMap<>();

		for (char c : s.toCharArray()) {
			sMap.put(c, sMap.getOrDefault(c, 0) + 1);
		}

		for (char ch : t.toCharArray()) {
			if ((sMap.containsKey(ch) && sMap.get(ch) == 0) || !sMap.containsKey(ch)) {
				return ch;
			} else {
				sMap.put(ch, sMap.get(ch) - 1);
			}
		}
		return ' ';
	}

}
