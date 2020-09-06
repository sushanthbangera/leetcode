package com.leetcode.strings;

import java.util.function.Predicate;

/*
 * 520. Detect Capital
 * https://leetcode.com/problems/detect-capital/
 */
public class DetectCapital {

	/*
	 * Time: O(N) Space: O(1)
	 */
	public boolean detectCapitalUse(String word) {
		int capsCount = 0;
		boolean isFirstCaps = isCap(word.charAt(0));

		for (int i = 0; i < word.length(); i++) {
			if (isCap(word.charAt(i))) {
				capsCount++;
			}
		}
		if (capsCount == 1 && isFirstCaps) {
			return true;
		}
		return capsCount == word.length() || capsCount == 0;
	}

	private boolean isCap(char c) {
		int num = c - 'A';
		return num > -1 && num < 26;
	}

	/*
	 * Using isUpperCase method of Character class Time: O(N) Space: O(1)
	 */
	public boolean detectCapitalUse2(String word) {

		int trueCount = 0;

		for (int i = 0; i < word.length(); i++) {
			if (Character.isUpperCase(word.charAt(i))) {
				trueCount++;
			}
		}

		if (trueCount == 1 && Character.isUpperCase(word.charAt(0))) {
			return true;
		}

		return trueCount == word.length() || trueCount == 0;
	}

	/*
	 * Time: varies from O(1) to O(2^N) as it depends on implementation of regex
	 */
	public boolean detectCapitalUse3(String word) {
		return word.matches("[A-Z]*|.[a-z]*");
	}

	/*
	 * Advantage: need not check all the characters in case of invalid String
	 */
	public boolean detectCapitalUse4(String word) {
		Predicate<Character> caseCheck = Character::isLowerCase;

		if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
			caseCheck = Character::isUpperCase;
		}

		for (int i = 1; i < word.length(); i++) {
			if (!caseCheck.test(word.charAt(i)))
				return false;
		}
		return true;
	}

}
