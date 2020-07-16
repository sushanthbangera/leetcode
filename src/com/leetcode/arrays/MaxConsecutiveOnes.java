package com.leetcode.arrays;

/*
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int maxOnes = 0;
		int current = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				current++;
			} else {
				maxOnes = Math.max(maxOnes, current);
				current = 0;
			}
		}
		return Math.max(maxOnes, current);
	}
}
