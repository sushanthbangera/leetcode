package com.leetcode.arrays;

import com.leetcode.utils.ArrayUtils;

/*
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class DuplicatesRemover {

	/*
	 * Time: O(n)
	 */
	public int removeDuplicates(int[] nums) {

		int len = nums.length;

		int slowPointer = 0;

		for (int i = 1; i < len; i++) {
			if (nums[i - 1] != nums[i]) {
				nums[++slowPointer] = nums[i];
			}
		}
		return slowPointer + 1;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 2 };
		DuplicatesRemover rd = new DuplicatesRemover();
		rd.removeDuplicates(nums);
		ArrayUtils.print(nums);
	}
}
