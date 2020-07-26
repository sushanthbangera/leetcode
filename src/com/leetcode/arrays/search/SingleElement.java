package com.leetcode.arrays.search;

/*
 * 540. Single Element in a Sorted Array
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElement {

	/*
	 * Time: O(logN) Space: O(1)
	 */
	public int singleNonDuplicate(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			int mid = (start + end) / 2;
			if (mid % 2 == 1)
				mid--;

			if (nums[mid] != nums[mid + 1]) {
				end = mid;
			} else {
				start = mid + 2;
			}
		}
		return nums[start];
	}
}
