package com.leetcode.trees;

import java.util.PriorityQueue;

/*
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {

	public int findKthLargest(int[] nums, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k); // minHeap of Size k initial capacity

		for (int i = 0; i < nums.length; i++) {
			minHeap.offer(nums[i]);

			if (minHeap.size() > k) { // removing the min element when size of heap is greater than k
				minHeap.poll();
			}
		}
		return minHeap.poll();
	}
}
