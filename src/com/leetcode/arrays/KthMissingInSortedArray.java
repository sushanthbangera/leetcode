package com.leetcode.arrays;

/*
 * 
 */
public class KthMissingInSortedArray {

	/*
	 * Time: O(n)
	 */
	public int findMissingElement(int arr[], int k) {

		int count = k;
		int len = arr.length - 1;
		int difference = 0;
		int result = -1;

		for (int i = 0; i < len - 1; i++) {
			difference = 0;
			
			if (arr[i] != arr[i + 1]) {
				difference = (arr[i + 1] - arr[i]) - 1;
				
				if (difference >= count) {
					result = arr[i] + count;
					return result;
				} else {
					count -= difference;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {2, 3, 5, 6, 8, 9};
		
		KthMissingInSortedArray kmiss = new KthMissingInSortedArray();
		System.out.println(kmiss.findMissingElement(arr, 1));
		System.out.println(kmiss.findMissingElement(arr, 2));
		System.out.println(kmiss.findMissingElement(arr, 3));
	}
}
