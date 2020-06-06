package com.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostFrequentWord {

	public String mostCommonWord(String paragraph, String[] banned) {

		HashSet<String> bannedWords = new HashSet<>();
		for (String bannedWord : banned) {
			bannedWords.add(bannedWord);
		}

		String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");

		Map<String, Integer> frequencyMap = new HashMap<>();

		for (String word : words) {
			if (!bannedWords.contains(word)) {
				frequencyMap.put(word, frequencyMap.containsKey(word) ? frequencyMap.get(word) + 1 : 1);
			}
		}

		String frequentWord = "";

		for (String word : frequencyMap.keySet()) {
			if (frequentWord.equals("") || (frequencyMap.get(word) > frequencyMap.get(frequentWord))) {
				frequentWord = word;
			}
		}

		return frequentWord;
	}

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";

		String banned[] = { "hit" };

		MostFrequentWord mostFrequentWord = new MostFrequentWord();

		System.out.println("Most Frequent word : " + mostFrequentWord.mostCommonWord(paragraph, banned));
	}
}
