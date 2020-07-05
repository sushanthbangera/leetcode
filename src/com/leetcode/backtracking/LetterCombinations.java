package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

	public List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<>();

		if (digits == "" || digits.length() == 0) {
			return result;
		}

		String mapping[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		createCombinations(digits, 0, mapping, result, "");
		return result;
	}

	private void createCombinations(String digits, int index, String[] mapping, List<String> result, String curr) {

		if (curr.length() == digits.length()) {
			result.add(curr);
			return;
		}

		int digit = digits.charAt(index) - '0';
		String str = mapping[digit];

		for (int i = 0; i < str.length(); i++) {
			createCombinations(digits, index + 1, mapping, result, curr + str.charAt(i));
		}
	}
}
