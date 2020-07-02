package com.leetcode.dp;

/*
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/ 
 */
public class UniquePathWithObstacles {

	/*
	 * Time: O(m*n) Space: O(m*n)
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int dp[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 0) {
				dp[i][0] = 1;
			} else {
				break; // it cannot reach other rows once there is a obstacle
			}
		}

		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 0) {
				dp[0][j] = 1;
			} else {
				break; // it cannot reach other columns once there is a obstacle
			}

		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
