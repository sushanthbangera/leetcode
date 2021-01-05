package com.leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {

	/*
	 * Time: O(nLogn) Space: O(N)
	 * 
	 * the overall runtime is dominated by the complexity of sort
	 */
	public String largestNumber(int[] nums) {

		if (nums.length == 0)
			return "";

		String[] strNums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strNums[i] = Integer.toString(nums[i]);
		}

		Comparator<String> comp = (a, b) -> {
			String s1 = a + b;
			String s2 = b + a;
			return s2.compareTo(s1);
		};

		Arrays.sort(strNums, comp);

		StringBuilder strBuilder = new StringBuilder();
		for (String s : strNums) {
			strBuilder.append(s);
		}

		if (strNums[0].equals("0")) {
			return "0";
		}

		return strBuilder.toString();
	}
}
