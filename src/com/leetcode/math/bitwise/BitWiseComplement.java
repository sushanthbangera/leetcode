package com.leetcode.math.bitwise;

/*
 * 476. Number Complement
 * 1009. Complement of Base 10 Integer
 * 
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class BitWiseComplement {

	/*
	 * 100110, its complement is 011001, the sum is 111111. So we only need get the
	 * min number large or equal to num, then do substraction
	 */
	public int bitwiseComplement(int N) {

		int num = 0;
		int i = 0;

		if (N == 0)
			return 1;

		while (num < N) {
			num += Math.pow(2, i);
			i++;
		}

		return num - N;
	}

	public int bitwiseComplement2(int N) {

		if (N == 0) return 1;
		 
		int num = 0;

		while (num < N) {
			num = (num << 1) | 1;
		}

		return num - N;
	}
}
