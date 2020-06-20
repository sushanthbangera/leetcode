package com.leetcode.matrices;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.utils.ArrayUtils;

/*
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

	public List<Integer> spiralMatrix(int[][] matrix) {
		List<Integer> nums = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return nums;
		}
		int top = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		int size = matrix.length * matrix[0].length;

		while (nums.size() < size) {

			for (int i = left; i <= right && nums.size() < size; i++) {
				nums.add(matrix[top][i]);
			}
			top++;
			for (int i = top; i <= bottom && nums.size() < size; i++) {
				nums.add(matrix[i][right]);
			}
			right--;
			for (int i = right; i >= left && nums.size() < size; i--) {
				nums.add(matrix[bottom][i]);
			}
			bottom--;
			for (int i = bottom; i >= top && nums.size() < size; i--) {
				nums.add(matrix[i][left]);
			}
			left++;
		}
		return nums;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> spiralMatNums = new SpiralMatrix().spiralMatrix(mat);
		ArrayUtils.print(spiralMatNums.toArray());

		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		spiralMatNums = new SpiralMatrix().spiralMatrix(matrix);
		ArrayUtils.print(spiralMatNums.toArray());
	}
}
