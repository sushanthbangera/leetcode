package com.leetcode.dp;

/*
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostForClimbing {

	/*
	 * Time: O(N) Space: O(1)
	 */
	public int minCostClimbingStairs(int[] cost) {

		int a = cost[0], b = cost[1];

		for (int i = 2; i < cost.length; i++) {
			int sum = cost[i] + Math.min(a, b);
			a = b;
			b = sum;
		}

		return Math.min(a, b);
	}

	public static void main(String[] args) {
		int cost[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		MinCostForClimbing mc = new MinCostForClimbing();
		System.out.println(mc.minCostClimbingStairs(cost));
	}
}
