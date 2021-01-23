package com.leetcode.dp;

import com.leetcode.utils.ArrayUtils;

/*
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BuySellStock {

	public int maxProfit(int[] prices) {
		int n = prices.length;

		if (n <= 1)
			return 0;

		int s0[] = new int[n];
		int s1[] = new int[n];
		int s2[] = new int[n];

		s0[0] = 0;
		s1[0] = -prices[0];
		s2[0] = Integer.MIN_VALUE;

		for (int i = 1; i < n; i++) {
			ArrayUtils.print(prices);
			ArrayUtils.print(s0);
			ArrayUtils.print(s1);
			ArrayUtils.print(s2);
			System.out.println("----------------------------");

			s0[i] = Math.max(s0[i - 1], s2[i - 1]);
			s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
			s2[i] = s1[i - 1] + prices[i];
		}

		ArrayUtils.print(prices);
		ArrayUtils.print(s0);
		ArrayUtils.print(s1);
		ArrayUtils.print(s2);
		System.out.println("----------------------------");
		return Math.max(s0[n - 1], s2[n - 1]);
	}

	public static void main(String[] args) {
		int prices[] = { 1, 2, 3, 0, 2 };
		BuySellStock bs = new BuySellStock();
		System.out.println(bs.maxProfit(prices));
	}
}
