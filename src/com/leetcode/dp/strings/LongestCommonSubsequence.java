package com.leetcode.dp.strings;

/*
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

	
	public int longestCommonSubsequence(String text1, String text2) {
		int len1 = text1.length();
		int len2 = text2.length();

		Integer dp[][] = new Integer[len1][len2];

		return longestCommonSubsequence(text1, text2, 0, 0, dp);
	}

	private Integer longestCommonSubsequence(String s1, String s2, int i1, int i2, Integer dp[][]) {

		if (i1 == s1.length() || i2 == s2.length())
			return 0;

		if (dp[i1][i2] == null) {
			Integer c1 = 0, c2 = 0, c3 = 0;
			if (s1.charAt(i1) == s2.charAt(i2)) {
				c1 = 1 + longestCommonSubsequence(s1, s2, i1 + 1, i2 + 1, dp);
			}
			c2 = longestCommonSubsequence(s1, s2, i1, i2 + 1, dp);
			c3 = longestCommonSubsequence(s1, s2, i1 + 1, i2, dp);
			dp[i1][i2] = Math.max(c1, Math.max(c2, c3));
		}
		return dp[i1][i2];
	}
	
	public int longestCommonSubsequenceBottomUp(String text1, String text2) {
		int len1 = text1.length();
		int len2 = text2.length();

		int dp[][] = new int[len1 + 1][len2 + 1];
		
		for (int i = len1; i > 0; i--) {
			
			for (int j = len2; j > 0; j--) {
				
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i - 1][j - 1] = Math.max(1 + dp[i][j], Math.max(dp[i][j - 1], dp[i - 1][j]));
				} else {
					dp[i - 1][j - 1] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[0][0];
	}
}
