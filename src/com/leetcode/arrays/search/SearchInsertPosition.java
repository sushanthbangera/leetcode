package com.leetcode.arrays.search;

/*
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;

		return search(nums, low, high, target);
	}

	private int search(int[] nums, int low, int high, int target) {

		if (low > high) {
			return high + 1;
		}
		
		int mid = (low + high) / 2;
		
		if (nums[mid] > target) {
			return search(nums, low, mid - 1, target);
		} 
		
		if(nums[mid] < target) {
			return search(nums, mid + 1, high, target);
		}
		
		return mid;
	}
	
	public static void main(String[] args) {
		SearchInsertPosition sip = new SearchInsertPosition();
		int nums[] = {1, 3, 5, 6};
		int target = 5;
		System.out.println(sip.searchInsert(nums, target));
	}
}
