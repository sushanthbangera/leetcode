package com.leetcode.dp;

/*
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 */
public class DeocdeWays {

	/*
	 * Time: O(n)
	 */
	public int numDecodings(String s) {

		int len = s.length();

		int dp[] = new int[len + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i <= len; i++) {
			int oneDigit = s.charAt(i - 1) - '0';
			int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';

			if (oneDigit >= 1) {
				dp[i] += dp[i - 1];
			}

			if (twoDigits >= 10 && twoDigits <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[len];
	}

	public static void main(String[] args) {
		DeocdeWays dways = new DeocdeWays();
		String s = "12";
		System.out.println("Decode ways: " + dways.numDecodings(s));
	}
}
