package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/*
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/
 */
public class SingleNumberII {

	/*
	 * Time: O(N) Space: O(1)
	 */
	public int singleNumber(int[] nums) {

		Set<Integer> set = new HashSet<>();
		long uniqueNumberSum = 0;
		long sequenceSum = 0;

		for (int n : nums) {
			if (!set.contains(n)) {
				set.add(n);
				uniqueNumberSum += n;
			}
			sequenceSum += n;
		}

		return (int) ((3 * uniqueNumberSum - sequenceSum) / 2);
	}

	public static void main(String[] args) {
		int a[] = { 43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648, 43, 2147483647,
				-2147483646, -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646, -2147483647, 16,
				16, 2147483646, 43 };
		
		SingleNumberII singleNum = new SingleNumberII();
		System.out.println(singleNum.singleNumber(a));
	}
}
