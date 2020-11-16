package com.leetcode.strings.substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 30. Substring with Concatenation of All Words
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class FindSubString {

	public List<Integer> findSubstring(String s, String[] words) {

		List<Integer> result = new ArrayList<>();

		if (words.length == 0 || s.length() == 0) {
			return result;
		}
		// Store all the words count in a map
		// foo: 1; bar: 1
		Map<String, Integer> wordsMap = new HashMap<>();
		for (String word : words) {
			wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
		}

		int singleWordLength = words[0].length();
		int allWordsLength = singleWordLength * (words.length);

		// take substring of length equals to length of all words concatenated
		// barfoo, arfoot, ...
		for (int i = 0; i <= s.length() - allWordsLength; i++) {

			String subStr = s.substring(i, i + allWordsLength);

			Map<String, Integer> substrMap = new HashMap<>();

			int k = 0;

			// get substring equals to one word length and store the count
			// barfoo => bar: 1; foo: 1
			for (int j = 0; j < words.length; j++) {
				String wordSubStr = subStr.substring(k, k + singleWordLength);
				if (wordsMap.containsKey(wordSubStr)) { // store only if substring is part of words
					substrMap.put(wordSubStr, substrMap.getOrDefault(wordSubStr, 0) + 1);
				}
				k = k + singleWordLength;
			}

			if (substrMap.equals(wordsMap)) {
				result.add(i);
			}

		}
		return result;
	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String words[] = { "foo", "bar" };

		FindSubString findSubString = new FindSubString();
		System.out.println(findSubString.findSubstring(s, words).toString());
	}
}
