package com.leetcode.dp;

/*
 * 518. Coin Change 2
 * https://leetcode.com/problems/coin-change-2/
 */
public class CoinChangeWays {

	public int change(int amount, int[] coins) {

		int coinLen = coins.length;
		int dp[][] = new int[coinLen + 1][amount + 1];

		for (int i = 0; i < coinLen + 1; i++) {
			dp[i][0] = 1; // num of ways of selecting sum 0 is 1
		}

		for (int i = 1; i < coinLen + 1; i++) {
			for (int j = 0; j < (amount + 1); j++) {
				if (coins[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				}
			}
		}
		return dp[coinLen][amount];
	}
}
