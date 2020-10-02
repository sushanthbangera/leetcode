package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 216. Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/
 */

public class CombinationSum3 {

	public List<List<Integer>> combinationSum3(int k, int n) {
		Set<List<Integer>> tempResult = new HashSet<>();
		List<Integer> temp = new ArrayList<>();

		backtrack(tempResult, temp, n, k, 1);

		List<List<Integer>> result = new ArrayList<>();
		result.addAll(tempResult);

		return result;
	}

	private void backtrack(Set<List<Integer>> tempResult, List<Integer> temp, int target, int k, int num) {

		if (target < 0)
			return;

		if (target == 0 && temp.size() == k) {
			tempResult.add(new ArrayList<>(temp));
			return;
		}

		while (num < 10 && target - num >= 0) {
			temp.add(num);
			backtrack(tempResult, temp, target - num, k, ++num);
			temp.remove(temp.size() - 1);
		}
	}

}
