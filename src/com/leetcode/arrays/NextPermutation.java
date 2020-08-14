package com.leetcode.arrays;

/*
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

	/*
	 * Time: O(N)  Space: O(1)
	 */
	public void nextPermutation(int[] nums) {

		int i = nums.length - 2;

		// move from right to left till u find a number less than its higher index
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		// find the position to swap, i.e. the right end is in decreasing order
		// find the number just close to the element found above and then swap
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		// if array is in descending order not possible to find hence reversing the number
		reverse(nums, i + 1);
	}

	private void reverse(int[] nums, int start) {
		int low = start, high = nums.length - 1;
		while (low < high) {
			swap(nums, low, high);
			low++;
			high--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
