package com.leetcode.strings;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacter {

	/*
	 * Time: O(n) Space: O(1) // max 26 characters
	 */
	public int firstUniqChar2(String s) {

		Map<Character, Integer> freqMap = new LinkedHashMap<>();

		if (s == null || s.length() == 0) {
			return -1;
		}
		int len = s.length();

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (freqMap.get(ch) == 1) {
				return i;
			}
		}
		return -1;
	}
}

class CountIndex {

	int count;

	int index;

	public CountIndex(int index) {
		this.count = 1;
		this.index = index;
	}

	public void increment() {
		this.count++;
	}

	public int getIndex() {
		return this.index;
	}

	public int getCount() {
		return this.count;
	}
}
