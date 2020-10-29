package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges/
 */
public class SummaryRanges {

	/*
	 * Time: O(n) Space: O(1)
	 */
	public List<String> summaryRanges(int[] nums) {

		List<String> result = new ArrayList<>();

		if (nums.length == 0) {
			return result;
		}

		int start = nums[0];
		int end = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (Math.abs(nums[i] - nums[i - 1]) > 1) {
				result.add(start != end ? (start + "->" + end) : String.valueOf(start));
				start = nums[i];
			}
			end = nums[i];
		}
		result.add(start != end ? (start + "->" + end) : String.valueOf(start));
		return result;
	}

	/*
	 * Time: O(n) Space: O(1)
	 */
	public List<String> summaryRanges2(int[] nums) {
		int start = 0;
		int end = 0;

		List<String> list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
				end++;
				i++;
			}
			if (start == end) {
				list.add(String.valueOf(nums[start]));
			} else {
				list.add(nums[start] + "->" + nums[end]);
			}
			end++;
			start = end;
		}
		return list;
	}
}
