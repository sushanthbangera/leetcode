package com.leetcode.arrays.search;

/*
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstLastIndexSearch {

	/*
	 * Time: O(log n) - Binary search is invoked twice
	 * Space: O(1)
	 */
	public int[] searchRange(int[] nums, int target) {

		int targetRange[] = { -1, -1 };
		int leftIndex = getExtremePosition(nums, target, true);

		if (leftIndex == nums.length || nums[leftIndex] != target) {
			return targetRange;
		}

		targetRange[0] = leftIndex;
		targetRange[1] = getExtremePosition(nums, target, false) - 1;

		return targetRange;
	}

	private int getExtremePosition(int nums[], int target, boolean left) {

		int low = 0;
		int high = nums.length;

		while (low < high) {

			int mid = (low + high) / 2;

			if (nums[mid] > target || (left && nums[mid] == target)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}
}
