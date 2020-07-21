package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/*
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

	/*
	 * Time: O(numRows^2) -> Rows updates: 1 + 2 + 3 + .... +numRows => numRows*(numRows+1)/2 
	 * 
	 * Space: O(numRows^2)
	 */
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<>();

		if (numRows == 0)
			return result;

		result.add(new ArrayList<>());
		result.get(0).add(1);

		for (int i = 1; i < numRows; i++) {
			List<Integer> currentList = new ArrayList<>();
			List<Integer> prevRow = result.get(i - 1);
			
			currentList.add(1); // first value is always 1
			for (int j = 1; j < i; j++) {
				currentList.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			currentList.add(1); // last value is always 1
			result.add(currentList);
		}
		return result;
	}
}
