package com.leetcode.math.bitwise;

/*
 * 461. Hamming Distance
 * https://leetcode.com/problems/hamming-distance/
 */
public class HammingDistance {

	/*
	 * Time: O(n) where n is the number of bits which are different
	 *
	 */
	public int hammingDistance(int x, int y) {

		int result = 0;
		int n = x ^ y;

		// find the number of 1 bits
		while (n != 0) {
			n = n & n - 1;
			result++;
		}

		return result;
	}
}
