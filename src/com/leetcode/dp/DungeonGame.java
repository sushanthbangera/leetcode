package com.leetcode.dp;

/*
 * 174. Dungeon Game
 * https://leetcode.com/problems/dungeon-game/
 */
public class DungeonGame {

	/*
	 * Time: O(m)(n) Space: O(m)(n)
	 */
	public int calculateMinimumHP(int[][] dungeon) {

		if (dungeon == null || dungeon.length == 0)
			return 0;
		int row = dungeon.length;
		int col = dungeon[0].length;

		int dp[][] = new int[row + 1][col + 1];

		for (int i = 0; i <= row; i++) {
			dp[i][col] = Integer.MAX_VALUE;
		}

		for (int i = 0; i <= col; i++) {
			dp[row][i] = Integer.MAX_VALUE;
		}

		dp[row - 1][col] = 0;
		dp[row][col - 1] = 0;

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				int minCell = Math.min(dp[i + 1][j], dp[i][j + 1]);
				dp[i][j] = Math.max(minCell - dungeon[i][j], 0);
			}
		}
		return dp[0][0] + 1;
	}
}
