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

		for (int row = 1; row < coinLen + 1; row++) {
			for (int amt = 1; amt <= amount; amt++) {
				
				if (coins[row - 1] > amt) {
					dp[row][amt] = dp[row - 1][amt];
				} else {
					dp[row][amt] = dp[row - 1][amt] + dp[row][amt - coins[row - 1]];
				}
			}
		}
		return dp[coinLen][amount];
	}
}
