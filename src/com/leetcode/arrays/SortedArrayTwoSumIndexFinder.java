package com.leetcode.arrays;

/*
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class SortedArrayTwoSumIndexFinder {

	public int[] getTwoSumIndexes2(int[] nums, int target) {
		
		int len = nums.length;
		int low = 0, high = len - 1;
		
		while (low < high) {
			int sum = nums[low] + nums[high];
			
			if (sum > target) {
				high--;
			} else if (sum < target) {
				low++;
			} else {
				return new int[] {low + 1, high + 1};
			} 
		}
		throw new IllegalArgumentException("No Two Sum Found");
	}
}
