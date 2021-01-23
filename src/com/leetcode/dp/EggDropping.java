package com.leetcode.dp;

/*
 * 
 */
public class EggDropping {

	/*
	 * Approach: Recursion. <Time limit exceeded> Time: Exponential Space: O(1)
	 */
	public int superEggDrop(int K, int N) {

		if (N == 0 || N == 1) {
			return N;
		}

		if (K == 1) {
			return N;
		}

		int min = Integer.MAX_VALUE;
		int result;

		for (int i = 1; i <= N; i++) {
			// K eggs at floor i leads to two cases
			// Egg Doesn't Breaks -> K eggs remain and floors above it has to be tested ->
			// (K, N - i)
			// Egg Breaks -> Egg reduces by 1 and floors below it has to be tested -> (K -
			// 1, i - 1)
			result = Math.max(superEggDrop(K, N - i), superEggDrop(K - 1, i - 1));
			if (result < min) {
				min = result;
			}
		}

		return min + 1;
	}

	/*
	 * Time: O(K * N^2)  Space: O(K * N)
	 */
	public int superEggDrop2(int K, int N) {

		int dp[][] = new int[K + 1][N + 1];

		// 0 floors or 1 floor
		for (int i = 1; i <= K; i++) {
			dp[i][1] = 1;
			dp[i][0] = 0;
		}

		// 1 egg
		for (int i = 1; i <= N; i++) {
			dp[1][i] = i;
		}

		int result = 0;

		for (int egg = 2; egg <= K; egg++) {

			for (int floor = 2; floor <= N; floor++) {

				dp[egg][floor] = Integer.MAX_VALUE;

				for (int f = 1; f <= floor; f++) {

					result = 1 + Math.max(dp[egg][floor - f], dp[egg - 1][f - 1]);

					if (result < dp[egg][floor]) {
						dp[egg][floor] = result;
					}
				}
			}
		}

		return dp[K][N];
	}

	public int superEggDrop3(int K, int N) {
		
		// Right now, dp[i] represents dp(1, i) i.e. 1 egg N floors
		int[] dp = new int[N + 1];
		
		for (int i = 0; i <= N; ++i) {
			dp[i] = i;
		}

		for (int k = 2; k <= K; ++k) {
			// Now, we will develop dp2[i] = dp(k, i)
			int[] dp2 = new int[N + 1];
			int x = 1;
			for (int n = 1; n <= N; ++n) {
				// Let's find dp2[n] = dp(k, n)
				// Increase our optimal x while we can make our answer better.
				// Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
				// is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
				while (x < n && Math.max(dp[x - 1], dp2[n - x]) > Math.max(dp[x], dp2[n - x - 1]))
					x++;

				// The final answer happens at this x.
				dp2[n] = 1 + Math.max(dp[x - 1], dp2[n - x]);
			}

			dp = dp2;
		}

		return dp[N];
	}

	public static void main(String[] args) {

		int N = 5000;
		int K = 8;

		EggDropping eg = new EggDropping();
		System.out.println(eg.superEggDrop(K, N));
		System.out.println(eg.superEggDrop2(K, N));
	}
}
