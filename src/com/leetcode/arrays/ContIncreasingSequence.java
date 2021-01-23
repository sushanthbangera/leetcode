package com.leetcode.arrays;

/*
 * 674. Longest Continuous Increasing Subsequence
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class ContIncreasingSequence {

	/*
	 * Time: O(N) Space: O(1)
	 */
	public int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int pointer = 0;
		int maxLength = 0;

		for (int i = 0; i < nums.length; i++) {

			if (i > 0 && nums[i - 1] >= nums[i]) {
				pointer = i;
			}
			maxLength = Math.max(maxLength, i - pointer + 1);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		int nums[] = {1, 3, 5, 4, 7};
		ContIncreasingSequence conIncSeq = new ContIncreasingSequence();
		System.out.println(conIncSeq.findLengthOfLCIS(nums));
	}
}
