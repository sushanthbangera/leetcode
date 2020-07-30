package com.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1091. Shortest Path in Binary Matrix
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class ShortestPathBinaryMatrix {

	/*
	 * Time: O(mn) Space: O(mn)
	 */
	public int shortestPathBinaryMatrix(int[][] grid) {

		if (grid == null || grid.length == 0)
			return -1;

		int row = grid.length;
		int col = grid[0].length;

		int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 } };

		if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1)
			return -1;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		grid[0][0] = 1;

		int result = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {

				int[] loc = queue.remove();

				if (loc[0] == row - 1 && loc[1] == col - 1) {
					return result + 1;
				}

				for (int i = 0; i < 8; i++) {
					int nextX = loc[0] + dir[i][0];
					int nextY = loc[1] + dir[i][1];

					if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && grid[nextX][nextY] == 0) {
						queue.add(new int[] { nextX, nextY });
						grid[nextX][nextY] = 1;
					}
				}
			}
			result++;
		}
		return -1;
	}
}
