package com.leetcode.math;

/*
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Fibonacci {

	public int fib(int N) {
		int a = 0, b = 1;

		if (N == 0)
			return a;
		if (N == 1)
			return b;

		for (int i = 2; i <= N; i++) {
			int fSum = a + b;
			a = b;
			b = fSum;
		}
		return b;
	}

}
