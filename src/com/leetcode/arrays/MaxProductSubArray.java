package com.leetcode.arrays;

/*
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaxProductSubArray {

	/*
	 * Time: O(N) Space O(N)
	 */
	public int maxProduct(int[] nums) {

		int n = nums.length;

		int maxProduct[] = new int[n];
		int minProduct[] = new int[n];
		int result[] = new int[n];
		maxProduct[0] = nums[0];
		minProduct[0] = nums[0];
		result[0] = nums[0];

		for (int i = 1; i < n; i++) {

			int choice1 = maxProduct[i - 1] * nums[i];
			int choice2 = minProduct[i - 1] * nums[i];

			maxProduct[i] = Math.max(nums[i], Math.max(choice1, choice2));
			minProduct[i] = Math.min(nums[i], Math.min(choice1, choice2));

			result[i] = Math.max(result[i - 1], maxProduct[i]);
		}

		return result[n - 1];
	}
}
