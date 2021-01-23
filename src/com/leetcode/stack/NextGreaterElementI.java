package com.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

/*
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/ 
 */
public class NextGreaterElementI {

	/*
	 *  Time: O(m + n)
	 *  Space: O(m + n)
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int len = nums1.length;
		int len2 = nums2.length;

		HashMap<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < len; i++) {
			numMap.put(nums1[i], i);
		}

		int result[] = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = -1;
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < len2; i++) {
			while (!stack.isEmpty() && stack.peek() < nums2[i]) {
				int value = stack.pop();
				if (numMap.containsKey(value)) {
					result[numMap.get(value)] = nums2[i];
				}
			}
			stack.push(nums2[i]);
		}

		return result;
	}
	
	
	public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		
		int len = nums1.length;

		HashMap<Integer, Integer> numMap = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		
		int result[] = new int[len];
		
		for (int num : nums2) {
			while (!stack.isEmpty() && stack.peek() < num) {
				int v = stack.pop();
				numMap.put(v, num);				
			}
			stack.push(num);
		}
		
		for (int i = 0; i < len; i++) {
			result[i] = numMap.getOrDefault(nums1[i], -1);
		}
		
		return result;
	}
	
}
