package com.leetcode.dp;

/*
 * Time: O(m*n) Space: O(m*n)
 */
public class MinCostPath {

	public int minPathSum(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			dp[i][0] = Integer.MAX_VALUE;
		}

		for (int j = 0; j <= n; j++) {
			dp[0][j] = Integer.MAX_VALUE;
		}

		dp[0][1] = 0; // To make sure first comparison goes through successfully

		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= n; j++) {

				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
			}
		}

		return dp[m][n];
	}
}
