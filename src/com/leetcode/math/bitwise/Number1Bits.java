package com.leetcode.math.bitwise;

/*
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Number1Bits {

	// you need to treat n as an unsigned value

	/*
	 * run time depends on the number of bits - n is 32 bit Time: O(1) Space: O(1)
	 */
	public int hammingWeight(int n) {

		int result = 0;
		while (n != 0) {
			n = n & n - 1;
			result++;
		}

		return result;
	}

	/*
	 * run time depends on the number of bits - n is 32 bit Time: O(1) Space: O(1)
	 */
	public int hammingWeight2(int n) {
		int bits = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			// & operation starting with 1 and then left shift
			if ((n & mask) != 0) {
				bits++;
			}
			// ...0001 to ...0010
			mask <<= 1;
		}
		return bits;
	}
}
