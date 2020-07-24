package com.leetcode.math;

/*
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerOfTwo {

	/*
	 * Time: O(1)
	 */
	public boolean isPowerOfTwo(int n) {

		if (n <= 0)
			return false;

		return (n & (n - 1)) == 0;

	}

	public boolean isPowerOfTwo2(int n) {

		while (n % 2 == 0) {
			n = n / 2;
		}

		if (n == 1)
			return true;

		return false;
	}

	public static void main(String[] args) {
		PowerOfTwo p = new PowerOfTwo();
		int num = -2147483648;
		System.out.println(p.isPowerOfTwo(num));
		System.out.println(p.isPowerOfTwo2(num));
	}
}
