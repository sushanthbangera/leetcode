package com.leetcode.math;

/*
 * 1103. Distribute Candies to People
 * https://leetcode.com/problems/distribute-candies-to-people/
 */
public class DistributeCandiesToPeople {

	
	public int[] distributeCandies(int candies, int num_people) {

		int result[] = new int[num_people];
		int candy = 0;
		int index = 0;

		while (candies > 0) {
			int person = index % num_people;
			candy++;

			result[person] += Math.min(candies, candy);

			index++;
			candies -= candy;
		}

		return result;
	}
}
