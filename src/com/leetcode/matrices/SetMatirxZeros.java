package com.leetcode.matrices;

/*
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatirxZeros {

	/*
	 * Time: O(M*N) Space: O(M*N)
	 */
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0 && !visited[i][j]) {
					visited[i][j] = true;
					setZeros(matrix, i, j, visited);
				}
			}
		}
	}

	private void setZeros(int[][] matrix, int i, int j, boolean[][] visited) {

		// row
		for (int k = 0; k < matrix.length; k++) {
			if (!visited[k][j]) {
				visited[k][j] = true;
				if (matrix[k][j] == 0) {
					setZeros(matrix, k, j, visited);
				} else {
					matrix[k][j] = 0;
				}
			}
		}

		// column
		for (int r = 0; r < matrix[0].length; r++) {
			if (!visited[i][r]) {
				visited[i][r] = true;
				if (matrix[i][r] == 0) {
					setZeros(matrix, i, r, visited);
				} else {
					matrix[i][r] = 0;
				}
			}
		}
	}

	private static final int CONST = -10000;

	/*
	 * Time: O(M*N) Space: O(1)
	 */
	public void setZeroes2(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					setZeros(matrix, i, j);
				} else if (matrix[i][j] == CONST) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	private void setZeros(int[][] matrix, int i, int j) {
		// left
		for (int k = 0; k < j; k++) {
			matrix[i][k] = 0;
		}
		// right
		for (int k = j; k < matrix[0].length; k++) {
			if (matrix[i][k] != 0) {
				matrix[i][k] = CONST;
			}
		}
		// up
		for (int r = 0; r < i; r++) {
			matrix[r][j] = 0;
		}
		// down
		for (int r = i; r < matrix.length; r++) {
			if (matrix[r][j] != 0) {
				matrix[r][j] = CONST;
			}
		}
	}
	
	/*
	 * Time: O(M*N)  Space: O(N)
	 */
	public void setZeroes3(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		// since first pos is same for row and column
		// [0][0] used for 1st row status and isCol is used for 1st Column status
		Boolean isCol = false; 

		for (int i = 0; i < m; i++) {
			
			if (matrix[i][0] == 0) isCol = true;
			
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0; // just storing the status at first row and column
				}
			}
		}
		
		// Iterate over the array once again and using the first 
		// row and first column, update the elements.
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		// for first row
		if (matrix[0][0] == 0) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		
		// for first column
		if (isCol) {
			for (int j = 0; j < m; j++) {
				matrix[j][0] = 0;
			}
		}
		
	}
}
