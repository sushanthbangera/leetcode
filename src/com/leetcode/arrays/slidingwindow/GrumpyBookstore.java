package com.leetcode.arrays.slidingwindow;

/*
 * 1052. Grumpy Bookstore Owner
 * https://leetcode.com/problems/grumpy-bookstore-owner/ 
 */
public class GrumpyBookstore {

	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int satisfiedWithoutPower = 0;

		int satisfied = 0;
		int maxSatisfiedWithPower = 0;
		int ifPowerUsed = 0;

		int len = customers.length;

		for (int i = 0; i < len; i++) {
			if (grumpy[i] == 0) {
				satisfiedWithoutPower += customers[i];
			}
		}

		for (int i = 0; i < len - (X - 1); i++) {

			for (int j = i; j < X + i; j++) {
				if (grumpy[j] == 0) {
					satisfied += customers[j];
				}
				ifPowerUsed += customers[j];
			}

			if (ifPowerUsed - satisfied > 0) {
				maxSatisfiedWithPower = Math.max(maxSatisfiedWithPower, (ifPowerUsed - satisfied));
			}
			satisfied = 0;
			ifPowerUsed = 0;

		}
		return satisfiedWithoutPower + maxSatisfiedWithPower;
	}
}
