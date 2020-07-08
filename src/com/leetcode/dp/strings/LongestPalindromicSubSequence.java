package com.leetcode.dp.strings;

/*
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubSequence {

	public int longestPalindromeSubseq(String s) {

		int len = s.length();

		int dp[][] = new int[len][len];

		for (int col = 0; col < s.length(); col++) {

			for (int row = len - 1; row >= 0; row--) {

				if (row > col) {
					dp[row][col] = 0;
				} else if (row == col) {
					dp[row][col] = 1;
				} else if (s.charAt(row) == s.charAt(col)) {
					dp[row][col] = Math.max(2 + dp[row + 1][col - 1], Math.max(dp[row + 1][col], dp[row][col - 1]));
				} else {
					dp[row][col] = Math.max(dp[row + 1][col], dp[row][col - 1]);
				}
			}
		}
		return dp[0][len - 1];
	}

	public int longestPalindromeSubseq2(String s) {
		int len = s.length();
		int startIndex = 0;
		int endIndex = len - 1;

		Integer dp[][] = new Integer[len][len];
		return longestPalindromicTopDown(s, startIndex, endIndex, dp);
	}

	public int longestPalindromicTopDown(String s, int startIndex, int endIndex, Integer dp[][]) {

		if (startIndex > endIndex)
			return 0;

		if (startIndex == endIndex)
			return 1;

		if (dp[startIndex][endIndex] == null) {
			int c3 = 0;
			if (s.charAt(startIndex) == s.charAt(endIndex)) {
				c3 = 2 + longestPalindromicTopDown(s, startIndex + 1, endIndex - 1, dp);
			}

			int c1 = longestPalindromicTopDown(s, startIndex, endIndex - 1, dp);
			int c2 = longestPalindromicTopDown(s, startIndex + 1, endIndex, dp);

			dp[startIndex][endIndex] = Math.max(Math.max(c1, c2), c3);
		}

		return dp[startIndex][endIndex];
	}

	public static void main(String[] args) {
		String s = "sushabdsus";
		LongestPalindromicSubSequence lps = new LongestPalindromicSubSequence();
		System.out.println(lps.longestPalindromeSubseq2(s));
	}
}
