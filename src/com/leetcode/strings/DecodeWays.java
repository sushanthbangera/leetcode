package com.leetcode.strings;

public class DecodeWays {

	public int decodeWays(String s) {
		int dp[] = new int[s.length() + 1];
		dp[0] = 1; // no of ways to decode empty string
		dp[1] = s.charAt(0) == '0' ? 0 : 1; //no of ways to decode string of length 1

		for (int i = 2; i <= s.length(); i++) {
			int oneDigit = Integer.valueOf(s.substring(i - 1, i));
			int twoDigit = Integer.valueOf(s.substring(i - 2, i));

			if (oneDigit >= 1) {
				dp[i] += dp[i - 1];
			}
			if (twoDigit >= 10 && twoDigit <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		String s = "226";
		System.out.println("No of ways: " + new DecodeWays().decodeWays(s));
	}
}
