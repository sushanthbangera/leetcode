package com.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

	/*
	 * Time: O(N) and Space: O(N)
	 */
	public int singleNumber(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int n : nums) {
			if (map.containsKey(n)) {
				map.remove(n);
			} else {
				map.put(n, 1);
			}
		}
		// only one element would remain in the map
		return map.keySet().iterator().next();
	}

	/*
	 * Time: O(N) and Space: O(N)
	 */
	public int singleNumber2(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				return key;
			}
		}
		return -1;
	}

	/*
	 * 2*(a + b + c) - (2a + 2b + c) = c Time: O(N) Space: O(N)
	 */
	public int singleNumber3(int[] nums) {

		Set<Integer> set = new HashSet<>();
		int uniqueNumbersSum = 0;
		int sequenceSum = 0;

		for (int n : nums) {
			if (!set.contains(n)) {
				set.add(n);
				uniqueNumbersSum += n;
			}
			sequenceSum += n;
		}

		return 2 * uniqueNumbersSum - sequenceSum;
	}

	/*
	 * XOR with same numbers reduces to 0 Time: O(N) Space: O(1)
	 */
	public int singleNumber4(int[] nums) {
		int result = 0;

		for (int n : nums) {
			result = result ^ n;
		}
		return result;
	}
}
