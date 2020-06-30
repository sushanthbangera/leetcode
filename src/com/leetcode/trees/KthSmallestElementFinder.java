package com.leetcode.trees;

import java.util.PriorityQueue;

public class KthSmallestElementFinder {

	public static int findKthSmallestElement(int[] nums, int k) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		for (int n : nums) {
			maxHeap.offer(n);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return maxHeap.poll();
	}

	public static void main(String[] args) {

		int arr[] = { 3, 4, 1, 9, 5, 8 };
		int k = 3;

		System.out.println("The Kth (" + k + ") smallest element is : " + findKthSmallestElement(arr, k));

		int arr2[] = { 12, 3, 5, 7, 19 };
		k = 4;
		System.out.println("The Kth (" + k + ") smallest element is : " + findKthSmallestElement(arr2, k));
	}
}
