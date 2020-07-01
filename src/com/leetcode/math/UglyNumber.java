package com.leetcode.math;

/*
 * 263. Ugly Number
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {

	public boolean isUgly(int num) {
		if (num == 0 || num < 0) {
			return false;
		}
		while (num != 1) {
			if (num % 2 == 0) {
				num = num / 2;
				continue;
			}
			if (num % 3 == 0) {
				num = num / 3;
				continue;
			}
			if (num % 5 == 0) {
				num = num / 5;
				continue;
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int num = 1000;

		UglyNumber ug = new UglyNumber();
		System.out.println(ug.isUgly(num) ? "Ugly Number" : "Not a Ugly Number");
	}
}
