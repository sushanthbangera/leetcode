package com.leetcode.matrices;

/*
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/submissions/
 */
public class MatrixRotator {

	/*
	 *  Time: O(n)
	 */
	public void rotate(int[][] matrix) {

		int n = matrix.length;

		int end = n - 1;

		for (int i = 0; i < n / 2; i++) {

			for (int j = 0; j < (n - 1 - 2 * i); j++) { // left ++ and right -- => reduce 2twice

				int temp = matrix[i][i + j];

				matrix[i][i + j] = matrix[end - i - j][i];

				matrix[end - i - j][i] = matrix[end - i][end - i - j];

				matrix[end - i][end - i - j] = matrix[i + j][end - i];

				matrix[i + j][end - i] = temp;

			}
		}
	}
}
