package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

	/*
	 * Time: O(n^2)
	 */
	public List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> resultList = new HashSet<>();

		if (nums == null || nums.length == 0) {
			new ArrayList<List<Integer>>(resultList);
		}

		Arrays.sort(nums);
		int len = nums.length;

		for (int i = 0; i < len - 1; i++) {
			int firstNum = nums[i];
			int low = i + 1, high = len - 1;

			while (low < high) {
				int sum = nums[low] + nums[high] + firstNum;

				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(firstNum);
					list.add(nums[low]);
					list.add(nums[high]);
					low++;
					high--;
					resultList.add(list);
				} else if (sum < 0) {
					low++;
				} else {
					high--;
				}
			}
		}
		return new ArrayList<List<Integer>>(resultList);
	}
}
