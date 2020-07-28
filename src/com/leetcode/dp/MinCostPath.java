package com.leetcode.dp;

/*
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinCostPath {

	/*
	 * Time: O(m*n) Space: O(m*n)
	 */
	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		int dp[][] = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				dp[i][j] = grid[i][j];
				if (i > 0 && j > 0) {
					dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
				} else if (i > 0) {
					dp[i][j] += dp[i - 1][j];
				} else if (j > 0) {
					dp[i][j] += dp[i][j - 1];
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public int minPathSum2(int[][] grid) {

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
