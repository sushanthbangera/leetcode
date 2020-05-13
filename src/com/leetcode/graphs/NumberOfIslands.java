package com.leetcode.graphs;

/*
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/ 
 */
public class NumberOfIslands {

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
					BFS(grid, i, j);
				}
			}
		}
		return count;
	}

	private void BFS(char[][] grid, int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
			return;
		}
		// mark the grid visited and its surrounding grids '0'
		grid[i][j] = '0';
		BFS(grid, i + 1, j);
		BFS(grid, i - 1, j);
		BFS(grid, i, j - 1);
		BFS(grid, i, j + 1);
	}
}
