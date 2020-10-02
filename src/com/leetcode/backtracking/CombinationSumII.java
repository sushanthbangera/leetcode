package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 */
public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int candidates[], int target) {
		Set<List<Integer>> tempResult = new HashSet<>();

		Arrays.sort(candidates);
		List<Integer> temp = new ArrayList<>();
		backtrack(tempResult, temp, target, candidates, 0);

		List<List<Integer>> result = new ArrayList<>();

		result.addAll(tempResult);

		return result;
	}

	private void backtrack(Set<List<Integer>> result, List<Integer> temp, int target, int candidates[], int i) {

		if (target < 0)
			return;

		if (target == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}

		while (i < candidates.length && target - candidates[i] >= 0) {
			temp.add(candidates[i]);
			backtrack(result, temp, target - candidates[i], candidates, ++i);
			temp.remove(temp.size() - 1);
		}

	}
}
