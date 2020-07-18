package com.leetcode.arrays;

/*
 * 941. Valid Mountain Array
 * https://leetcode.com/problems/valid-mountain-array/
 */
public class ValidMountainArray {

	/*
	 * Time: O(N) Space: O(1)
	 */
	public boolean validMountainArray(int[] A) {
		int len = A.length;
		int i = 0;

		while (i < len - 1 && A[i + 1] > A[i]) {
			i++;
		}
		if (i == 0 || i == len - 1)
			return false;

		while (i < len - 1 && A[i + 1] < A[i]) {
			i++;
		}
		return (i == len - 1);
	}
}
