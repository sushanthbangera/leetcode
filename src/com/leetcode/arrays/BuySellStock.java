package com.leetcode.arrays;

/*
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuySellStock {

	/*
	 * Time: O(n^2) Space: O(1)
	 */
	public int maxProfit(int prices[]) {

		int maxprofit = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if (profit > maxprofit)
					maxprofit = profit;
			}
		}
		return maxprofit;
	}

	/*
	 * Time: O(n) - 3 passes Space: O(2n)
	 */
	public int maxProfit2(int[] prices) {

		if (prices == null || prices.length == 0)
			return 0;

		int maxProfit = 0;

		int n = prices.length;
		int min[] = new int[n];
		int max[] = new int[n];

		min[0] = prices[0];
		for (int i = 1; i < n; i++) {
			min[i] = Math.min(min[i - 1], prices[i]);
		}

		max[n - 1] = prices[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			max[i] = Math.max(max[i + 1], prices[i]);
		}

		for (int i = 0; i < n; i++) {
			if (min[i] < max[i]) {
				int profit = max[i] - min[i];
				maxProfit = Math.max(profit, maxProfit);
			}
		}
		return maxProfit;
	}

	/*
	 * Time: O(n) Space: O(1)
	 */
	public int maxProfit3(int[] prices) {

		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}

		return maxProfit;
	}
}
