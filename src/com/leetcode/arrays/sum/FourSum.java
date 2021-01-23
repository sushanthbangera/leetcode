package com.leetcode.arrays.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	/*
	 * Time: O(n^4) - if the numbers are repeated you will get duplicate set of
	 * numbers
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> resultList = new ArrayList<>();

		int n = nums.length;

		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				i++;

			for (int j = i + 1; j < n - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					j++;

				for (int k = j + 1; k < n - 1; k++) {

					for (int l = k + 1; l < n; l++) {

						if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
							List<Integer> currentList = new ArrayList<>();
							currentList.add(nums[i]);
							currentList.add(nums[j]);
							currentList.add(nums[k]);
							currentList.add(nums[l]);

							resultList.add(currentList);
						}
					}
				}
			}
		}
		return resultList;
	}

	public List<List<Integer>> fourSum2(int[] nums, int target) {

		List<List<Integer>> resultList = new ArrayList<>();
		int n = nums.length;
		Arrays.sort(nums);

		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				i++;
				continue;
			}
			for (int j = i + 1; j < n - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					j++;
					continue;
				}

				int reqTarget = nums[i] + nums[j];
				List<List<Integer>> currentList = twoSum(nums, j + 1, reqTarget);

				for (List<Integer> cList : currentList) {
					List<Integer> list = new ArrayList<>();
					list.addAll(Arrays.asList(nums[i], nums[j]));
					list.addAll(cList);

					resultList.add(list);
				}
			}
		}
		return resultList;
	}

	private List<List<Integer>> twoSum(int nums[], int start, int target) {
		List<List<Integer>> resultList = new ArrayList<>();
		int left = start;
		int right = nums.length - 1;

		while (left < right) {
			int curSum = nums[left] + nums[right];

			if (curSum < target || (left > start && nums[left] == nums[left - 1])) {
				left++;
			} else if (curSum > target || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
				right--;
			} else {
				resultList.add(Arrays.asList(nums[left++], nums[right--]));
			}
		}
		return resultList;
	}

	public static void main(String[] args) {
		
		
	}
}
