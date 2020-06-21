package com.leetcode.dp;

/*
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {

	public int rob(int[] nums) {

		int len = nums.length;

		int dp[] = new int[len + 2];
		dp[len] = 0;
		dp[len + 1] = 0;

		for (int i = len - 1; i >= 0; i--) {
			int includeCurrentHouse = nums[i] + dp[i + 2];
			int excludeCurrentHouse = dp[i + 1];
			dp[i] = Math.max(includeCurrentHouse, excludeCurrentHouse);
		}
		return dp[0];
	}

	public int rob2(int[] nums) {

		int len = nums.length;

		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		if (len == 2)
			return Math.max(nums[0], nums[1]);

		int dp[] = new int[len];
		dp[0] = nums[0];
		dp[1] = Math.max(dp[0], nums[1]);

		for (int i = 2; i < len; i++) {
			int includeCurrentHouse = nums[i] + dp[i - 2];
			int excludeCurrentHouse = dp[i - 1];
			dp[i] = Math.max(includeCurrentHouse, excludeCurrentHouse);
		}

		return dp[len - 1];
	}
}
