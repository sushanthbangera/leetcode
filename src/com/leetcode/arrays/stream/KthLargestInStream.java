package com.leetcode.arrays.stream;

import java.util.PriorityQueue;

/*
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestInStream {

	private PriorityQueue<Integer> elements;

	private int klarge;

	public KthLargestInStream(int k, int[] nums) {
		int i = 0;
		klarge = k;
		elements = new PriorityQueue<>();
		while (nums != null && i < nums.length) {
			elements.offer(nums[i]);

			if (elements.size() > klarge) {
				elements.poll();
			}
			i++;
		}
	}

	public int add(int val) {

		if (elements.size() < klarge) {
			elements.offer(val);
		} else if (val > elements.peek()) {
			elements.offer(val);
			if (elements.size() > klarge) {
				elements.poll();
			}
		}

		return elements.peek();
	}
}
