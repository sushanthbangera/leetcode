package com.leetcode.dp;

/*
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

	/*
	 * Time: O(m*n) Space: O(m*n)
	 */
	public int uniquePaths(int m, int n) {

		int dp[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1; // number of ways to reach first row's is 1
		}

		for (int j = 0; j < n; j++) {
			dp[0][j] = 1; // number of ways to reach first column's is 1
		}

		for (int i = 1; i < m; i++) {

			for (int j = 1; j < n; j++) {

				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}

		return dp[m - 1][n - 1];
	}
}
