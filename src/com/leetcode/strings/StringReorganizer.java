package com.leetcode.strings;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * 767. Reorganize String
 * https://leetcode.com/problems/reorganize-string/
 */
public class StringReorganizer {

	public String reorganizeString(String S) {
		HashMap<Character, Integer> charMap = new HashMap<>();

		for (char c : S.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}

		// MaxHeap for sorting the map based on frequency of characters
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charMap.get(b) - charMap.get(a));
		maxHeap.addAll(charMap.keySet());

		StringBuilder resultStr = new StringBuilder();

		while (maxHeap.size() > 1) { // Since we are removing 2 elements at a time
			char top = maxHeap.remove();
			char second = maxHeap.remove();

			resultStr.append(top);
			resultStr.append(second);

			charMap.put(top, charMap.get(top) - 1); // after using the character decrease the count in map
			charMap.put(second, charMap.get(second) - 1);

			// If the characters are available add back to maxHeap
			if (charMap.get(top) > 0) {
				maxHeap.add(top);
			}

			if (charMap.get(second) > 0) {
				maxHeap.add(second);
			}
		}

		// The last remaining character should have only one count,
		if (!maxHeap.isEmpty()) {
			char last = maxHeap.remove();
			if (charMap.get(last) > 1) {
				return "";
			}
			resultStr.append(last);
		}
		return resultStr.toString();
	}

	public static void main(String[] args) {
		StringReorganizer stringReorganizer = new StringReorganizer();

		String S = "aab";
		System.out.println("The organised string: " + stringReorganizer.reorganizeString(S));

		S = "aaab";
		System.out.println("The organised string: " + stringReorganizer.reorganizeString(S));
	}
}
