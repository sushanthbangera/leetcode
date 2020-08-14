package com.leetcode.dp;

import java.util.Arrays;

/*
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/	
 */
public class CoinChange {

	/*
	 * Time: O(n*S) Space: O(S)
	 */
	public int coinChange(int[] coins, int amount) {
		// Ex: amount = 1 and Coins {1, 2, 5}	
		
		int max = amount + 1;

		int dp[] = new int[amount + 1];

		// [12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
		Arrays.fill(dp, max);

		// [0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
		dp[0] = 0;
		
		for (int amt = 1; amt <= amount; amt++) {

			for (int i = 0; i < coins.length; i++) {
				if (coins[i] <= amt) {
					// [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3]
					// dp[4] if coin 1 => dp[3] + 1 (coin 1 used), if coin 2 => dp[2] + 1 (coin 2 used)
					// thus min is 2 => dp[4] = 2
					dp[amt] = Math.min(dp[amt], dp[amt - coins[i]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
	
	public int coinChangeTopDown(int[] coins, int amount) {
		if (amount < 1) return amount;
		int dp[] = new int[amount];
		return coinChangeTopDown(coins, amount, dp);
	}
	
	private int coinChangeTopDown(int[] coins, int amount, int[] dp) {
		
		if (amount < 0) return -1;
		
		if (amount == 0) return 0;
		
		if (dp[amount - 1] != 0) return dp[amount -1];
		
		int min = Integer.MAX_VALUE;
		
		for (int coin : coins) {

			int res = coinChangeTopDown(coins, amount - coin, dp);
			
			if (res >= 0 && res < min) {
				min = 1 + res; // "current coin (1) + num coins for rem amt"
			}
		}
		
		dp[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return dp[amount - 1];
	}
}
