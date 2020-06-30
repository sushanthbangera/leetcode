package com.leetcode.arrays;

import java.util.Arrays;

/*
 * 881. Boats to Save People
 * https://leetcode.com/problems/boats-to-save-people/
 */
public class SafeBoats {

	public int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);

		int startIndex = 0;
		int endIndex = people.length - 1;

		int numBoats = 0;

		while (startIndex < endIndex) {

			if (people[startIndex] + people[endIndex] <= limit) {
				startIndex++;
				endIndex--;
			} else {
				endIndex--;
			}
			numBoats++;
		}

		return numBoats;
	}
}
