package com.leetcode.arrays.search;

/*
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class MinRotatedArray {

	/*
	 * Time: O(logN)  Space: O(1)
	 */
	public int findMin(int[] nums) {

		int len = nums.length;

		int low = 0, high = len - 1;

		while (low < high) {

			int mid = (low + high) / 2;

			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return nums[low];
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
	
	public static void main(String[] args) {
		MinRotatedArray rotArray = new MinRotatedArray();
		int arr[] = {2, 3, 4, 5, 6, 1}; // ascending rotated
		System.out.println(rotArray.findMin(arr));
		int arr2[] = {3, 2, 1, 6, 5, 4}; // descending rotated
		System.out.println(rotArray.findMin(arr2));
	}
}
