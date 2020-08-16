package com.leetcode.arrays.buysellstock;

/*
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BuySellStockII {

	/*
	 * Time: O(n) Space: O(1)
	 */
	public int maxProfit(int[] prices) {

		int n = prices.length;
		int profit = 0;
		int i = 0;

		while (i < n - 1) {
			while (i < n - 1 && prices[i + 1] <= prices[i]) {
				i++;
			}

			int buyVal = prices[i];

			while (i < n - 1 && prices[i + 1] >= prices[i]) {
				i++;
			}
			int sellVal = prices[i];

			profit += sellVal - buyVal;
		}

		return profit;
	}

	/*
	 * Time: O(n) Space: O(1)
	 */
	public int maxProfit2(int[] prices) {
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}
}
