package com.leetcode.strings;

/*
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {

	public String countAndSay(int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				result = "1";
				continue;
			}
			result = countAndSay(result);
		}
		return result;
	}

	private String countAndSay(String input) {
		StringBuilder result = new StringBuilder();
		char curr = input.charAt(0);
		int count = 1;

		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) != curr) {
				result.append(count).append(curr);
				count = 1;
				curr = input.charAt(i);
				continue;
			}
			count++;
		}
		result.append(count).append(curr);
		return result.toString();
	}

}
