package com.leetcode.arrays;

public class LCSAbsoluteDiff {

	public int longestSubarray(int[] nums, int limit) {
		int longestSub = -1;

		int low = 0;
		int pointer = 0;
		
		while (pointer < nums.length) {
			
			if (Math.abs(nums[low] - nums[pointer]) <= limit) {
				
			} else {
				low++;
			}
			pointer++;
		}
		
		return longestSub;
	}
	
	public static void main(String[] args) {
		LCSAbsoluteDiff lcs = new LCSAbsoluteDiff();
		int nums[] = {8, 2, 4, 7};
		int limit = 4;
		System.out.println(lcs.longestSubarray(nums, limit));
	}
}
