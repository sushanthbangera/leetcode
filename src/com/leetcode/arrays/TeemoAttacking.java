package com.leetcode.arrays;

/*
 * 495. Teemo Attacking
 * https://leetcode.com/problems/teemo-attacking/
 */
public class TeemoAttacking {

	/*
	 * Time: O(n) Space: O(1)
	 */
	public int findPoisonedDuration(int[] timeSeries, int duration) {

		int n = timeSeries.length;
		if (n == 0)
			return 0;

		int result = 0;

		for (int i = 0; i < n - 1; i++) {
			result += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
		}

		return result + duration;
	}
}
