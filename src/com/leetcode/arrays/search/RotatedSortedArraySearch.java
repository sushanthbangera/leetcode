package com.leetcode.arrays.search;

/*
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class RotatedSortedArraySearch {

	public int search(int nums[], int target) {

		int len = nums.length;
		
		int pivot = findPivot(nums, 0, len - 1);
		
		// Array is not rotated - do a normal binary search
		if (pivot == -1) {
			return binarySearch(nums, 0, len - 1, target);
		}
				
		if (nums[pivot] == target) return pivot;
		
		if (nums[0] <= target) return binarySearch(nums, 0, pivot - 1, target);
		
		return binarySearch(nums, pivot + 1, len - 1, target);
	}
	
	private int findPivot(int arr[], int low, int high) {
		
		if (low > high) return -1;
		
		if (low == high) return low;
		
		int mid = (low + high) / 2;
		
		//  [----------, 7, 8, 0, ---------] if mid is at pivot 8
		if (mid < high && arr[mid] > arr[mid + 1]) return mid;
		
	    //  [----------, 7, 8, 0, ---------] if mid is at 0
		if (low < mid && arr[mid] < arr[mid - 1]) return (mid - 1);
		
		// [7, 8, 1, 2, -----------] if mid is at 2
		if (arr[low] >= arr[mid]) return findPivot(arr, low, mid - 1);
		
		// [4, 5, 6, 7, 1, 2, 3, 4] if mid is at 7
		return findPivot(arr, mid + 1, high);
	}

	private int binarySearch(int arr[], int low, int high, int key) {

		if (low > high)
			return -1;

		int mid = (low + high) / 2;

		if (arr[mid] == key)
			return mid;

		if (key < arr[mid])
			return binarySearch(arr, low, mid - 1, key);

		return binarySearch(arr, mid + 1, high, key);
	}
	
	public int search(int nums[], int low, int high, int target) {
		
		if (low > high) return -1;
		
		int mid = (low + high) / 2;
		
		if (nums[mid] == target) return mid;
		
		// nums[low----mid] is sorted
		if (nums[low] <= nums[mid]) {
			
			if (target <= nums[mid] && target >= nums[low]) {
				return search(nums, low, mid - 1, target);
			}
			
			return search(nums, mid + 1, high, target);
		}
		
		if (target >= nums[mid] && target <= nums[high]) {
			return search(nums, mid + 1, high, target);
		}
		
		return search(nums, low, mid - 1, target);
	}
	
	public static void main(String[] args) {
		
		int arr[] = {4, 5, 6, 7, 8, 0, 1, 2};
		
		RotatedSortedArraySearch rotArrSearch = new RotatedSortedArraySearch();
		System.out.println(rotArrSearch.search(arr, 5));
		
		System.out.println(rotArrSearch.search(arr, 0, arr.length - 1, 5));
	}

}
