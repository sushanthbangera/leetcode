package com.leetcode.arrays.search;

/*
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class MinRotatedArray {

	/*
	 * Iterative Solution
	 */
	public int findMin(int[] nums) {

		int len = nums.length;

		int low = 0, high = len - 1;
		int target = nums[high];

		while (low + 1 < high) {

			int mid = (low + high) / 2;

			if (nums[mid] <= target) {
				high = mid;
			} else {
				low = mid;
			}
		}

		if (nums[low] <= target) {
			return nums[low];
		} else {
			return nums[high];
		}
	}

	/*
	 * Recursive Solution
	 */
	public int findMin2(int[] nums) {

		int min = findMin(nums, 0, nums.length - 1);

		if (min == Integer.MAX_VALUE || min == nums.length - 1) {
			return Math.min(nums[0], nums[nums.length - 1]);
		}

		return nums[min];
	}

	private int findMin(int nums[], int low, int high) {

		if (low > high)
			return Integer.MAX_VALUE;

		if (low == high)
			return low;

		int mid = (low + high) / 2;

		if (mid < high && nums[mid] > nums[mid + 1]) {
			return mid + 1;
		}

		if (low < mid && nums[mid] < nums[mid - 1]) {
			return mid;
		}

		if (nums[low] < nums[mid]) {
			return findMin(nums, mid + 1, high);
		}

		return findMin(nums, low, mid - 1);
	}
}
