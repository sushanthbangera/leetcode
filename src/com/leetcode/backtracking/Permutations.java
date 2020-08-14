package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		backtrack(resultList, tempList, nums);
		return resultList;
	}

	private void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int nums[]) {
		if (tempList.size() == nums.length) {
			resultList.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue;
				tempList.add(nums[i]);
				backtrack(resultList, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Permutations per = new Permutations();
		int nums[] = {1, 2, 3};
		per.permute(nums);
	}
}
