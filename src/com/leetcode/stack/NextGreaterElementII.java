package com.leetcode.stack;

import java.util.Stack;

/*
 * 503. Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class NextGreaterElementII {

	public int[] nextGreaterElements(int[] nums) {

		int len = nums.length;
		int result[] = new int[len];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < 2 * len; i++) {
			
			int num = nums[i % len];

			while (!stack.isEmpty() && nums[stack.peek()] < num) {
				int index = stack.pop();
				result[index] = num;
			}

			if (i < len) {
				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		return result;
	}
}
