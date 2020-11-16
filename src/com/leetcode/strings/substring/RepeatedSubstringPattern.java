package com.leetcode.strings.substring;

public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String s) {

		int len = s.length();

		for (int i = len / 2; i >= 1; i--) {
			if (len % i == 0) {
				
				int m = len / i;
				String subStr = s.substring(0, i);
				
				StringBuilder strBuilder = new StringBuilder();
				for (int k = 0; k < m; k++) {
					strBuilder.append(subStr);
				}

				if (strBuilder.toString().equals(s)) {
					return true;
				}
			}
		}
		return false;
	}
}
