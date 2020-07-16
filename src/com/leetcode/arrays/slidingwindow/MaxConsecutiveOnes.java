package com.leetcode.arrays.slidingwindow;

/*
 * 1004. Max Consecutive Ones III
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnes {

	/*
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int longestOnes(int[] A, int K) {

		int maxCount = 0;
		int currentCount = 0;
		int startIndex = 0;

		for (int i = 0; i < A.length; i++) {

			if (A[i] == 1) {
				currentCount++;
			} else if (K > 0) {
				K--;
				currentCount++;
			} else {
				maxCount = Math.max(maxCount, currentCount);
				while (A[startIndex] == 1) {
					startIndex++;
				}
				startIndex++;
				currentCount = i - startIndex + 1;
			}
		}

		return Math.max(maxCount, currentCount);
	}
}
