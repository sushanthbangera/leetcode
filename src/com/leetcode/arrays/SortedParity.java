package com.leetcode.arrays;

/*
 * 905. Sort Array By Parity
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortedParity {
	/*
	 * Time: O(N) Space: O(1)
	 */
	public int[] sortArrayByParity(int[] A) {
		int evenIndex = -1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				evenIndex++;
				int temp = A[i];
				A[i] = A[evenIndex];
				A[evenIndex] = temp;
			}
		}
		return A;
	}
}
