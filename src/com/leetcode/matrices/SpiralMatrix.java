package com.leetcode.matrices;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.utils.ArrayUtils;

public class SpiralMatrix {

	public List<Integer> spiralMatrix(int[][] mat) {
		List<Integer> nums = new ArrayList<>();
		
		int top = 0;
		int bottom = mat.length - 1;
		int left = 0;
		int right = mat[0].length - 1;
		int size = mat.length * mat[0].length;
		
		while (nums.size() <= size) {
			
			for (int i = left; i <= right && nums.size() <= size; i++) {
				nums.add(mat[top][i]);
			}
			top++;
			for (int i = top; i <= bottom && nums.size() <= size; i++) {
				nums.add(mat[i][right]);
			}
			right--;
			for (int i = right; i >= 0 && nums.size() <= size; i--) {
				nums.add(mat[bottom][i]);
			}
			bottom--;
			for (int i = bottom; i >= top && nums.size() <= size; i--) {
				nums.add(mat[i][left]);
			}
			left++;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int mat[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> spiralMatNums = new SpiralMatrix().spiralMatrix(mat);
		ArrayUtils.print(spiralMatNums.toArray());
	}
}
