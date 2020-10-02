package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leetcode.utils.ArrayUtils;

/*
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 * 
 */
public class CombinationSum {
	

	public List<List<Integer>> combinationSum(int candidates[], int target) {
		List<List<Integer>> resultList = new ArrayList<>();

		Arrays.sort(candidates);
		
		List<Integer> cur = new ArrayList<>();

		recursiveCal(candidates, target, 0, resultList, cur);
		
		return resultList;
	}

	private void recursiveCal(int arr[], int target, int i, List<List<Integer>> res, List<Integer> cur) {

		if (target < 0) {
			return;
		}

		if (target == 0) {
			res.add(new ArrayList<>(cur));
			return;
		}

		// This prevents the tempList "cur" to add only if sum is less than the target
		while (i < arr.length && target - arr[i] >= 0) {
			cur.add(arr[i]);

			recursiveCal(arr, target - arr[i], i, res, cur);
			i++;
			
			cur.remove(cur.size() - 1);
		}
	}
	
	/*
	 * The recursion is more here since element is added even if the target is crossed
	 */
	private void backtrack(int arr[], int target, int index, List<List<Integer>> res, List<Integer> cur) {
		if (target < 0) {
			return;
		}

		if (target == 0) {
			res.add(new ArrayList<>(cur));
			return;
		}
		
		for (int i = index; i < arr.length; i++) {
			cur.add(arr[i]);
			backtrack(arr, target - arr[i], i, res, cur);
			cur.remove(cur.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 3, 6, 7};
		int target = 7;
		
		CombinationSum cs = new CombinationSum();
		List<List<Integer>> res = cs.combinationSum(arr, target);
		
		for (int i = 0; i < res.size(); i++) {
			
			List<Integer> subList = res.get(i);
			
			Object[] sub = subList.toArray();
			
			ArrayUtils.print(sub);

		}
	}
}
