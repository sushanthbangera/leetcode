package com.leetcode.arrays.sum;

import java.util.HashMap;
import java.util.Map;

/*
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

	/*
	 * Time: O(N) Space: O(N)
	 */
	public int[] twoSum(int[] nums, int target) {
		int len = nums.length;

		Map<Integer, Integer> indexMap = new HashMap<>();

		for (int i = 0; i < len; i++) {
			int coplement = target - nums[i];
			if (indexMap.containsKey(coplement)) {
				return new int[] { i, indexMap.get(coplement) };
			}
			indexMap.put(nums[i], i);
		}
		throw new IllegalArgumentException("No Two Sum Found");
	}
}
