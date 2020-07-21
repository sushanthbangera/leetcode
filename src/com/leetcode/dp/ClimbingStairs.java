package com.leetcode.dp;

/*
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
	
	/*
	 * Time: O(2^N)  Space: O(N)
	 */
	public int climbStairs(int n) {
		return climbStairs(0, n);
	}

	public int climbStairs(int i, int n) {

		if (i > n)
			return 0;

		if (i == n)
			return 1;

		return climbStairs(i + 1, n) + climbStairs(i + 2, n);
	}

	/*
	 * Memoization
	 * Time: O(N)  Space: O(N)
	 */
	public int climbStairs2(int n) {
		int dp[] = new int[n + 1];
		return climbStairs(dp, 0, n);
	}

	public int climbStairs(int dp[], int i, int n) {

		if (i > n)
			return 0;

		if (i == n)
			return 1;

		if (dp[i] > 0)
			return dp[i];

		dp[i] = climbStairs(dp, i + 1, n) + climbStairs(dp, i + 2, n);
		return dp[i];
	}
	
	/*
	 * Dynamic Programming
	 * Time: O(N)  Space: O(N)
	 */
	public int climbStairs3(int n) {
		if (n == 1) return 1;
		
		int dp[] = new int[n + 1];
		
		dp[1] = 1; dp[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	
	/*
	 * Fibonacci Series
	 * Time: O(N)  Space: O(1)
	 */
	public int climbStairs4(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		
		int first = 1;
		int second = 2;
		
		for (int i = 3; i <= n; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		
		return second;
	}

}
