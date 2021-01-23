package com.leetcode.arrays;

import java.util.Arrays;

/*
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {

	/*
	 * Time: O(NLogN)  Space: 
	 */
	public int eraseOverlapIntervals(int[][] intervals) {

		if (intervals.length == 0)
			return 0;
		
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

		int end = intervals[0][1];
		int count = 0;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= end) {
				end = intervals[i][1];
			} else {
				count++;
			}
		}
		return count;
	}
}
