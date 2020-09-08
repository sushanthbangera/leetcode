package com.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

	/*
	 * O(N) - N is the length of the pattern O(M) - No of unique pattern characters
	 */
	public boolean wordPattern(String pattern, String str) {

		String[] s = str.split("\\s+");

		if (pattern.length() != s.length) {
			return false;
		}

		Map<Character, String> dict = new HashMap<>();
		Set<String> strSet = new HashSet<>();

		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (dict.containsKey(c)) {
				if (!dict.get(c).equals(s[i])) {
					return false;
				}
			} else {
				if (strSet.contains(s[i])) {
					return false;
				}
				dict.put(c, s[i]);
				strSet.add(s[i]);
			}
		}

		return true;
	}

	/*
	 * O(N) - N is the length of the pattern O(M) - No of unique pattern characters
	 */
	public boolean wordPattern2(String pattern, String str) {

		Map mapIndex = new HashMap();
		String[] words = str.split(" ");

		if (words.length != pattern.length())
			return false;

		for (Integer i = 0; i < pattern.length(); i++) {

			char c = pattern.charAt(i);

			if (!mapIndex.containsKey(c)) {
				mapIndex.put(c, i);
			}

			if (!mapIndex.containsKey(words[i])) {
				mapIndex.put(words[i], i);
			}

			if (mapIndex.get(words[i]) != mapIndex.get(c)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
		String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";

		WordPattern wp = new WordPattern();
		System.out.print("Is pattern followed: " + wp.wordPattern2(pattern, str));
	}
}
