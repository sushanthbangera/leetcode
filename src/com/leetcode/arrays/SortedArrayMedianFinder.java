package com.leetcode.arrays;

/*
 * 4. Median of Two Sorted Arrays  
 * https://leetcode.com/problems/median-of-two-sorted-arrays/ 
 */
public class SortedArrayMedianFinder {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;
		int len = m + n;
		int k = 0, i = 0, j = 0;
		int mid = len / 2;
		int c[] = new int[mid + 1];

		while (i < m && j < n && k <= mid) {
			if (nums1[i] <= nums2[j]) {
				c[k] = nums1[i];
				i++;
			} else {
				c[k] = nums2[j];
				j++;
			}
			k++;
		}

		while (k <= mid && i < m) {
			c[k] = nums1[i];
			i++;
			k++;
		}
		while (k <= mid && j < n) {
			c[k] = nums2[j];
			j++;
			k++;
		}

		if (len == 0)
			return c[0];

		if (len % 2 == 0) {
			return (c[k - 1] + c[k - 2]) / 2.0;
		}
		return c[k - 1];
	}
}
