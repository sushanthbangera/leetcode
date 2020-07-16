package com.leetcode.arrays.slidingwindow;

/*
 * 1437. Check If All 1's Are at Least Length K Places Away
 * https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 */
public class KLengthApart {

	/*
	 * Time: O(n)
	 */
	public boolean kLengthApart(int[] nums, int k) {

		int prevIndex = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				if (prevIndex != -1 && (i - prevIndex - 1) < k) {
					return false;
				}
				prevIndex = i;
			}
		}
		return true;
	}
}
