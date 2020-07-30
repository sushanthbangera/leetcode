package com.leetcode.dp;

import java.util.Arrays;

/*
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncSubSequence {

	/*
	 * Recursion Time Limit Exceeded Time: O(2^n) size of recursion tree Space: O(n)
	 * recursion Depth
	 */
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		return auxLengthOfLIS(nums, Integer.MIN_VALUE, 0);
	}

	private int auxLengthOfLIS(int[] nums, int prevVal, int curPos) {
		if (curPos == nums.length)
			return 0;

		int include = 0;
		if (nums[curPos] > prevVal) {
			include = 1 + auxLengthOfLIS(nums, nums[curPos], curPos + 1);
		}
		int exclude = auxLengthOfLIS(nums, prevVal, curPos + 1);
		return Math.max(include, exclude);
	}

	/*
	 * Memoization Time: O(n^2) Space: O(n^2) for memo
	 */
	public int lengthOfLIS2(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int memo[][] = new int[nums.length + 1][nums.length];
		for (int row[] : memo) {
			Arrays.fill(row, -1);
		}
		return auxLengthOfLIS(nums, -1, 0, memo);
	}

	private int auxLengthOfLIS(int[] nums, int prevIndex, int curPos, int[][] memo) {
		if (curPos == nums.length)
			return 0;

		if (memo[prevIndex + 1][curPos] >= 0) {
			return memo[prevIndex + 1][curPos];
		}
		int include = 0;
		if (prevIndex < 0 || nums[curPos] > nums[prevIndex]) {
			include = 1 + auxLengthOfLIS(nums, curPos, curPos + 1, memo);
		}
		int exclude = auxLengthOfLIS(nums, prevIndex, curPos + 1, memo);

		memo[prevIndex + 1][curPos] = Math.max(include, exclude);
		return memo[prevIndex + 1][curPos];
	}

	/*
	 * Dynamic Programming Time: O(n^2) Space: O(n)
	 */
	public int lengthOfLIS3(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int dp[] = new int[nums.length];

		dp[0] = 1;

		int maxVal = 0, maxLength = 1;

		for (int i = 1; i < nums.length; i++) {
			maxVal = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					maxVal = Math.max(maxVal, dp[j]);
				}
			}
			dp[i] = maxVal + 1;
			maxLength = Math.max(maxLength, dp[i]);
		}
		return maxLength;
	}

	/*
	 * Time: O(nlogn) - binary search takes log n, Space: O(n) for dp array
	 */
	public int lengthOfLIS4(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;

		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == len) {
				len++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		LongestIncSubSequence lis = new LongestIncSubSequence();
		System.out.println(lis.lengthOfLIS4(arr));
	}

}
