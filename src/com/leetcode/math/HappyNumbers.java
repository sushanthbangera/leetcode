package com.leetcode.math;

import java.util.HashSet;

/*
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumbers {

	public boolean isHappy(int n) {

		HashSet<Integer> nums = new HashSet<>();

		while (true) {

			n = squareSum(n);

			if (n == 1)
				return true;

			if (nums.contains(n)) {
				return false;
			}

			nums.add(n);
		}
	}

	private int squareSum(int n) {
		int sum = 0;

		while (n != 0) {
			sum += Math.pow(n % 10, 2);
			n = n / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		int n = 19;
		HappyNumbers pn = new HappyNumbers();

		System.out.println(n + " is " + (pn.isHappy(n) ? "Happy Number" : " Not a Happy Number"));
	}
}
