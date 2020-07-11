package com.leetcode.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacter {

	/*
	 * Time: O(n)  Space: O(n)
	 */
	public int firstUniqChar(String s) {
		int len = s.length();
		Map<Character, CountIndex> freqMap = new HashMap<>();
		int result = Integer.MAX_VALUE;

		if (s == null || len == 0)
			return -1;

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (freqMap.containsKey(ch)) {
				freqMap.get(ch).increment();
			} else {
				freqMap.put(ch, new CountIndex(i));
			}
		}

		for (Map.Entry<Character, CountIndex> m : freqMap.entrySet()) {
			if (m.getValue().getCount() == 1 && m.getValue().getIndex() < result) {
				result = m.getValue().getIndex();
			}
		}
		return result != Integer.MAX_VALUE ? result : -1;
	}

	public int firstUniqChar2(String s) {
		int len = s.length();
		Map<Character, Integer> freqMap = new LinkedHashMap<>();

		if (s == null || len == 0)
			return -1;

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
