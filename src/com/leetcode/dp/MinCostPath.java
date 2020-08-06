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

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				
				dp[row][col] = grid[row][col];
				
				if (row > 0 && col > 0) {
					dp[row][col] += Math.min(dp[row - 1][col], dp[row][col - 1]);
				} else if (row > 0) {
					dp[row][col] += dp[row - 1][col];
				} else if (col > 0) {
					dp[row][col] += dp[row][col - 1];
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
