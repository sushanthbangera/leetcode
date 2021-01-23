package com.leetcode.dp;

import java.util.Arrays;

public class NumLongestIncSequence {

	public int findNumberOfLIS(int[] nums) {
		int N = nums.length;
		if (N <= 1)
			return N;
		int[] lengths = new int[N]; // lengths[i] = length of longest ending in nums[i]
		int[] counts = new int[N]; // count[i] = number of longest ending in nums[i]
		Arrays.fill(counts, 1);

		for (int i = 0; i < N; ++i) {

			for (int j = 0; j < i; ++j) {

				if (nums[j] < nums[i]) {

					if (lengths[j] >= lengths[i]) {

						lengths[i] = lengths[j] + 1;
						
						counts[i] = counts[j];

					} else if (lengths[j] + 1 == lengths[i]) {

						counts[i] += counts[j];
					}
				}
			}
		}

		int longest = 0, ans = 0;
		for (int length : lengths) {
			longest = Math.max(longest, length);
		}
		for (int i = 0; i < N; ++i) {
			if (lengths[i] == longest) {
				ans += counts[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		NumLongestIncSequence nlis = new NumLongestIncSequence();
		int arr[] = { 1, 2, 5, 4, 7 };
		System.out.println(nlis.findNumberOfLIS(arr));

		int arr2[] = { 2, 2, 2, 2, 2 };
		System.out.println(nlis.findNumberOfLIS(arr2));
	}
}
