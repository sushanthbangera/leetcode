package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/submissions/
 */
public class LongestConsecutiveSequence {

	/*
	 * Time: O(NlogN) for sorting Space: O(1) - if inplace sorting should be used
	 * then O(N)
	 */
	public int longestConsecutive(int[] nums) {
		int lcs = 0;
		if (nums.length == 0)
			return lcs;
		Arrays.sort(nums);

		int currentStreak = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] != nums[i]) {
				if (nums[i + 1] == (1 + nums[i])) {
					currentStreak++;
				} else {
					lcs = Math.max(lcs, currentStreak);
					currentStreak = 1;
				}
			}
		}
		return Math.max(lcs, currentStreak);
	}

	/*
	 * Time: O(N) Space: O(N) - hashset used for O(1) lookup
	 */
	public int longestConsecutive2(int[] nums) {

		Set<Integer> numSet = new HashSet<>();
		for (int n : nums) {
			numSet.add(n);
		}

		int lcs = 0;

		for (int n : numSet) {
			if (!numSet.contains(n - 1)) {
				int currentNum = n;
				int currentStreak = 1;

				while (numSet.contains(currentNum + 1)) {
					currentNum++;
					currentStreak++;
				}
				lcs = Math.max(lcs, currentStreak);
			}
		}
		return lcs;
	}

	public static void main(String[] args) {
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int nums[] = { 100, 4, 200, 3, 2, 1 };
		System.out.println(lcs.longestConsecutive(nums));
	}
}
