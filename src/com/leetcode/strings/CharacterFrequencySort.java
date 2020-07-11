package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class CharacterFrequencySort {

	/*
	 * if n is the length of String and m is the number of distinct characters
	 * Time: O(nlogm) Space: O(m)
	 */
	public String frequencySort(String s) {

		int len = s.length();
		StringBuilder str = new StringBuilder();

		Map<Character, Integer> freqMap = new HashMap<>();
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
		}

		freqMap.entrySet().forEach(item -> {
			maxHeap.offer(item.getKey());
		});

		while (!maxHeap.isEmpty()) {
			char c = maxHeap.poll();
			int count = freqMap.get(c);
			while (count-- > 0) {
				str.append(c);
			}
		}

		return str.toString();
	}

}
