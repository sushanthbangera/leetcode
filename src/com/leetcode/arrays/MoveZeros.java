package com.leetcode.arrays;

/*
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros {

	public void moveZeroes(int[] nums) {
		int len = nums.length;

		int c = 0;

		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				c++;
			} else {
				nums[i - c] = nums[i];
			}
		}

		if (c == 0) {
			return;
		}

		for (int i = len - 1; c > 0; i--, c--) {
			nums[i] = 0;
		}
	}

	public void moveZeroes2(int[] nums) {
		int len = nums.length;
		int j = -1;

		for (int i = 0; i < len; i++) {
			if (nums[i] != 0) {
				j++;
				if (i != j) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

}
