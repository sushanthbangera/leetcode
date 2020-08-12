package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/*
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {

	/*
	 * Time: O(numRows^2) -> Rows updates: 1 + 2 + 3 + .... +numRows => numRows*(numRows+1)/2 
	 * 
	 * Space: O(numRows^2)
	 */
	public List<Integer> getRow(int rowIndex) {
		int numRows = rowIndex + 1;

		if (numRows < 0)
			return new ArrayList<>();

		List<Integer> currentList = new ArrayList<>();
		currentList.add(1);

		for (int i = 1; i < numRows; i++) {
			List<Integer> prevRow = currentList;
			currentList = new ArrayList<>();

			currentList.add(1); // first value is always 1
			for (int j = 1; j < i; j++) {
				currentList.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			currentList.add(1); // last value is always 1
		}
		return currentList;
	}

	/*
	 * Time: O(numRows^2) -> Rows updates: 1 + 2 + 3 + .... +numRows => numRows*(numRows+1)/2 
	 * 
	 * Space: O(numRows)
	 */
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < rowIndex + 1; i++) {
			result.add(1);
			for (int j = i; j >= 0; j--) {
				if (j != 0 && j != i) {
					result.set(j, result.get(j) + result.get(j - 1));
				}
			}
		}
		return result;
	}
}
