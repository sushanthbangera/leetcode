package com.leetcode.dp;

/*
 256. Paint House
 https://leetcode.com/problems/paint-house/
 */
public class PaintHouse {

	public int minCosts(int[][] costs) {
		int len = costs.length;
		if (costs == null || len == 0) {
			return 0;
		}

		for (int i = 1; i < len; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
		}

		int m = len - 1;
		return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
	}

	public int minCosts2(int[][] costs) {
		int len = costs.length;
		if (costs == null || len == 0) {
			return 0;
		}

		int[][] matrix = new int[3][len];

		for (int j = 0; j < costs.length; j++) {
			if (j == 0) {
				matrix[0][j] = costs[j][0];
				matrix[1][j] = costs[j][1];
				matrix[2][j] = costs[j][2];
			} else {
				matrix[0][j] = Math.min(matrix[1][j - 1], matrix[2][j - 1]) + costs[j][0];
				matrix[1][j] = Math.min(matrix[0][j - 1], matrix[2][j - 1]) + costs[j][1];
				matrix[2][j] = Math.min(matrix[0][j - 1], matrix[1][j - 1]) + costs[j][2];
			}
		}

		int m = len - 1;
		return Math.min(Math.min(matrix[0][m], matrix[1][m]), matrix[2][m]);
	}

	public static void main(String[] args) {
		int costs[][] = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		System.out.println("Min cost: " + new PaintHouse().minCosts(costs));
		
		int costs2[][] = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		System.out.println("Min cost: " + new PaintHouse().minCosts2(costs2));
	}
}
