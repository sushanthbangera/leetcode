package com.leetcode.strings;

/*
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

	/*
	 * Time: O(m*n) Space: O(m*n)
	 */
	public int minDistance(String word1, String word2) {

		int len1 = word1.length();
		int len2 = word2.length();

		int dp[][] = new int[len1 + 1][len2 + 1];

		// If first string is empty, only option is to
		// insert all characters of second string
		for (int i1 = 0; i1 <= len1; i1++) {
			dp[i1][0] = i1; // Min.operations = i1;
		}

		// If second string is empty, only option is to
		// remove all characters of second string
		for (int i2 = 0; i2 <= len2; i2++) {
			dp[0][i2] = i2; // Min.operations = i2;
		}

		for (int i1 = 1; i1 <= len1; i1++) {
			for (int i2 = 1; i2 <= len2; i2++) {
				if (word1.charAt(i1 - 1) == word2.charAt(i2 - 1)) {
					dp[i1][i2] = dp[i1 - 1][i2 - 1];
				} else {
					dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2 - 1], Math.min(dp[i1 - 1][i2], dp[i1][i2 - 1]));
				}
			}
		}

		return dp[len1][len2];
	}
}
