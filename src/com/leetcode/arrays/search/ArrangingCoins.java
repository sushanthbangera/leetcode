package com.leetcode.arrays.search;

/*
 * 441. Arranging Coins
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {

	public int arrangeCoins(int n) {
		int stairs = 0;

		while (n >= 0) {
			n = n - (stairs + 1);
			stairs++;
		}

		return stairs - 1;
	}

	/*
	 *  1 + 2 + 3 + .... + k => k(k+1)/2
	 *  
	 *  find max k such that k(k+1)/2 < n
	 * 
	 * Time: O(logn) Space: O(1)
	 */
	public int arrangeCoinsLeetCode(int n) {
		long left = 0, right = n;
		long k, curr;
		
		while (left <= right) {
			
			k = left + (right - left) / 2;
			
			curr = k * (k + 1) / 2;

			if (curr == n)
				return (int) k;

			if (n < curr) {
				right = k - 1;
			} else {
				left = k + 1;
			}
		}
		return (int) right;
	}
}
