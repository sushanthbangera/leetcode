package com.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {

	/*
	 * Time: O(m*n)  Space: O(m*n) 
	 */
	public int orangesRotting(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;

		Queue<int[]> queue = new LinkedList<>();
		int freshOranges = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == 2) {
					queue.add(new int[] { row, col });
				} else if (grid[row][col] == 1) {
					freshOranges++;
				}
			}
		}

		if (freshOranges == 0) {
			return 0;
		}
		int dirs[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int count = 0;

		while (!queue.isEmpty()) {
			int qSize = queue.size();
			count++; // for every rotten in queue, make all its immediate oranges rotten
			for (int q = 0; q < qSize; q++) {
				int arr[] = queue.remove();

				for (int i = 0; i < dirs.length; i++) {
					int x = arr[0] + dirs[i][0];
					int y = arr[1] + dirs[i][1];

					if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2)
						continue;

					freshOranges--;
					grid[x][y] = 2;
					queue.add(new int[] { x, y });
				}
			}
		}

		return freshOranges == 0 ? count - 1 : -1;

	}
}
