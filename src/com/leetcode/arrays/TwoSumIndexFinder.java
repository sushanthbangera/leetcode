package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 *  1. Two Sum
 *  https://leetcode.com/problems/two-sum/
 */
public class TwoSumIndexFinder {

	// It takes time complexity O(n) and space O(n)
	public int[] getTwoSumIndexes(int[] nums, int target) {

		int len = nums.length;

		Map<Integer, Integer> indexMap = new HashMap<>();

		for (int i = 0; i < len; i++) {
			int coplement = target - nums[i];
			if (indexMap.containsKey(coplement)) {
				return new int[] {i, indexMap.get(coplement)};
			}
			indexMap.put(nums[i], i);
		}
		throw new IllegalArgumentException("No Two Sum Found");
	}

}
