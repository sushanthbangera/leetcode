package com.leetcode.arrays;

/*
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaxContiguousSubArraySum {

	/*
	 * time complexity : O(n)
	 */
	public int maxSubArray(int[] nums) {
		int len = nums.length;
		int maxSum = nums[0];
		int currentSum = maxSum;

		for (int i = 1; i < len; i++) {
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSum = Math.max(currentSum, maxSum);
		}
		return maxSum;
	}

	/*
	 * time complexity : O(n^2)
	 */
	public int getMaxContiguousSubArraySumBruteForce(int arr[]) {
		int maxSum = 0;
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			int currentSum = arr[i];
			for (int j = i + 1; j < len; j++) {
				currentSum += arr[j];
				maxSum = Math.max(currentSum, maxSum);
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int arr[] = { -2, 5, 2, -4, 2, 1 };
		
		MaxContiguousSubArraySum maxSubArray = new MaxContiguousSubArraySum();
		
		System.out.println("Max Sub Array Sum : " + maxSubArray.maxSubArray(arr));
		
		System.out.println("Max Sub Array Sum : " + maxSubArray.getMaxContiguousSubArraySumBruteForce(arr));
	}
}
