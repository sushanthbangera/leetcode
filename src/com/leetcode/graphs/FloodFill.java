package com.leetcode.graphs;

/*
 * 733. Flood Fill
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

	/*
	 * Time: O(N) all pixel visit Space: O(N) for call stack
	 */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int color = image[sr][sc];
		if (color != newColor) {
			dfs(image, sr, sc, color, newColor);
		}
		return image;
	}

	private void dfs(int[][] image, int r, int c, int color, int newColor) {
		if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
			return;
		}
		
		if (image[r][c] == color) {
			image[r][c] = newColor;
			dfs(image, r + 1, c, color, newColor);
			dfs(image, r - 1, c, color, newColor);
			dfs(image, r, c + 1, color, newColor);
			dfs(image, r, c - 1, color, newColor);
		}
	}
}
