package com.leetcode.arrays;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

	/*
	 * Time: O(nlogn) - sorting O(nlogn) and linear scan O(n) 
	 * Space: O(n)  - if in place sorting then O(1)
	 */
	public int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		LinkedList<int[]> merged = new LinkedList<>();

		for (int interval[] : intervals) {

			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}
}
