package com.leetcode.graphs;

public class WallsAndGates {

	/*
	 * Time Complexity: O(mn)  -> O(ROW x COL)
	 */
	public void wallsAndGates(int[][] rooms) {
		
		int m = rooms.length;
		int n = rooms[0].length;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					dfs(rooms, 0, i, j);
				}
			}
		}
		
	}
	
	private void dfs(int[][] rooms, int distance, int i, int j) {
		int m = rooms.length;
		int n = rooms[i].length;
		
		if (i < 0 || i >=m || j < 0 || j >= n || rooms[i][j] < distance) {
			return;
		}
		
		rooms[i][j] = distance;
		
		dfs(rooms, distance + 1, i + 1, j);
		dfs(rooms, distance + 1, i, j + 1);
		dfs(rooms, distance + 1, i - 1, j);
		dfs(rooms, distance + 1, i, j - 1);
	}
}
