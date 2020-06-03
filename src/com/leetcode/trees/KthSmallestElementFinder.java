package com.leetcode.trees;

public class KthSmallestElementFinder {

	public static void main(String[] args) {
		
		int arr[] = {3, 4, 1, 9, 5, 8};
		int k = 3;
		
		System.out.println("The Kth (" + k + ") smallest element is : " + findKthSmallestElement(arr, k));
		
		int arr2[] = { 12, 3, 5, 7, 19 };
		k = 4;
		System.out.println("The Kth (" + k + ") smallest element is : " + findKthSmallestElement(arr2, k));
	}
	
	public static int findKthSmallestElement(int[] arr, int k) {
		MinHeap minHeap = new MinHeap(arr);
		int smallestElement = 0;
		
		while (k > 1) {
			minHeap.extract();
			k--;
		}
		return smallestElement;
	}
}
