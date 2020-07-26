package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

/*
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubString {

	/*
	 * Time: O(|S| + |T|)
	 * Worst case we end up visiting s twice, once by left and then by right pointers
	 * S - length of String s and T - length of String t
	 * 
	 * Space:O(|S| + |T|).
	 * |S| - when window size equal to length of the String
	 * |T| - when t has all unique characters
	 */
	public String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0)
			return "";

		Map<Character, Integer> tMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			tMap.put(c, tMap.getOrDefault(c, 0) + 1);
		}

		int requiredSize = tMap.size();

		int left = 0, right = 0;

		int formed = 0;

		Map<Character, Integer> windowCounts = new HashMap<>();

		int[] ans = { -1, 0, 0 };

		while (right < s.length()) {

			char c = s.charAt(right);
			windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

			if (tMap.containsKey(c) && windowCounts.get(c).intValue() == tMap.get(c).intValue()) {
				formed++;
			}

			while (left <= right && formed == requiredSize) {

				c = s.charAt(left);

				if (ans[0] == -1 || right - left + 1 < ans[0]) {
					ans[0] = right - left + 1;
					ans[1] = left;
					ans[2] = right;
				}

				windowCounts.put(c, windowCounts.get(c) - 1);
				if (tMap.containsKey(c) && windowCounts.get(c).intValue() < tMap.get(c).intValue()) {
					formed--;
				}

				left++;
			}
			right++;
		}
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}
	
	/*
	 * Time: O(|S| + |T|) - but now 2 times iteration over filtered string
	 * This approach significance is seen when "t" length is very small or when s contains 
	 * many letters which are not present in t
	 */
	public String minWindow2(String s, String t) {
		
		if (s.length() == 0 || t.length() == 0)
			return "";

		Map<Character, Integer> tMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			tMap.put(c, tMap.getOrDefault(c, 0) + 1);
		}

		int requiredSize = tMap.size();
		
		List<Pair<Integer, Character>> filteredS = new ArrayList<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (tMap.containsKey(c)) {
				filteredS.add(new Pair<>(i, c));
			}
		}
		
		int left = 0, right = 0;

		int formed = 0;

		Map<Character, Integer> windowCounts = new HashMap<>();

		int[] ans = { -1, 0, 0 };
		
		while (right < filteredS.size()) {
			
			char c = filteredS.get(right).getValue();
			
			windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
			
			if (windowCounts.get(c).intValue() == tMap.get(c).intValue()) {
				formed++;
			}
			
			while (left <= right && formed == requiredSize) {
				
				c = filteredS.get(left).getValue();
				
				int end = filteredS.get(right).getKey();
				int start = filteredS.get(left).getKey();
				
				if (ans[0] == -1 || end - start + 1 < ans[0]) {
					ans[0] = end - start + 1;
					ans[1] = start;
					ans[2] = end;
				}
				
				windowCounts.put(c, windowCounts.get(c) - 1);
				if (windowCounts.get(c).intValue() < tMap.get(c).intValue()) {
					formed--;
				}
				
				left++;
			}
			right++;
		}
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}
}
