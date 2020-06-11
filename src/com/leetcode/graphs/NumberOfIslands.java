package com.leetcode.graphs;

/*
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/ 
 */
public class NumberOfIslands {

	/*
	 * Time Complexity: O(mn)  -> O(ROW x COL)
	 */
	public int numIslands(char[][] grid) {

		if (grid.length == 0) {
			return 0;
		}

		int row = grid.length;
		int col = grid[0].length;
		int count = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					count += 1;
					DFS(grid, i, j);
				}
			}
		}
		return count;
	}

	private void DFS(char[][] grid, int row, int col) {

		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
			return;
		}
		// mark the grid visited and its surrounding grids '0' to mark it as the part of current island
		grid[row][col] = '0';
		DFS(grid, row + 1, col);
		DFS(grid, row - 1, col);
		DFS(grid, row, col - 1);
		DFS(grid, row, col + 1);
	}
}
