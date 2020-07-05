package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

	/*
	 * Time: O(nlogn) Space: O(1) - if solving in place is allowed else O(n) space
	 * for temp array
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	/*
	 * Time: O(n) Space: O(n)
	 */
	public int majorityElement2(int[] nums) {

		int numCount = nums.length;
		int majorityLimit = numCount / 2;

		Map<Integer, Integer> numFreqMap = new HashMap<>();

		for (int n : nums) {
			numFreqMap.put(n, numFreqMap.getOrDefault(n, 0) + 1);
			if (numFreqMap.get(n) > majorityLimit) {
				return n;
			}
		}
		return -1;
	}

	/*
	 * Boyer-Moore Voting Algorithm Time: O(n) Space: O(1)
	 */
	public int majorityElement3(int[] nums) {

		int candidate = 0;
		int count = 0;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		return candidate;
	}
}
