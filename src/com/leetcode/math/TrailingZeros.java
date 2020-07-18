package com.leetcode.math;

/*
 * 172. Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class TrailingZeros {

	public int trailingZeroes(int n) {

		int result = 0;

		while (n != 0) {
			n = n / 5;
			result += n;
		}
		return result;
	}
}
