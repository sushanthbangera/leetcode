package com.leetcode.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 442. Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindDuplicates {

	/*
	 * Time: O(n) Space: O(n)
	 */
	public List<Integer> findDuplicates(int[] nums) {

		List<Integer> duplicates = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		for (int n : nums) {
			if (!set.add(n)) {
				duplicates.add(n);
			}
		}
		return duplicates;
	}

	/*
	 * Time: O(n) Space: O(1)
	 */
	public List<Integer> findDuplicates2(int[] nums) {

		List<Integer> duplicates = new ArrayList<>();

		// Since: 1 <= nums[i] <= n; where n is length of the array
		// make the index value obtained from num as negative
		// if its already negative then its a duplicate value.
		
		for (int n : nums) {
			int index = Math.abs(n) - 1; 
			if (nums[index] < 0) {
				duplicates.add(index + 1);
			}
			nums[index] = -nums[index];
		}
		return duplicates;
	}
}
