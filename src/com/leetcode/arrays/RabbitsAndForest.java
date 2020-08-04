package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * 781. Rabbits in Forest
 * https://leetcode.com/problems/rabbits-in-forest/
 */
public class RabbitsAndForest {

	public int numRabbits(int[] answers) {

		if (answers == null || answers.length == 0)
			return 0;

		Map<Integer, Integer> rabs = new HashMap<>();
		int totalRabbits = 0;

		for (int ans : answers) {
			if (ans == 0) {
				totalRabbits += 1;
			} else if (!rabs.containsKey(ans)) {
				//If we haven't accounted for this rabbit color then 
				//count = rabbit itself + the count the rabbit says
				totalRabbits += (ans + 1);
				rabs.put(ans, 0);
			} else {
                //if there are k of each color then they are all present, 
				//remove them to allow the change to account for others.
				rabs.put(ans, rabs.get(ans) + 1);
				if (rabs.get(ans) == ans) {
					rabs.remove(ans);
				}
			}
		}
		return totalRabbits;
	}
	
	public static void main(String[] args) {
		int answers[] = {10, 10, 10};
		RabbitsAndForest rabf = new RabbitsAndForest();
		System.out.println(rabf.numRabbits(answers));
	}
}
