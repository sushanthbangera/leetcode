package com.leetcode.arrays.search;

/*
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class RotatedSortedArraySearch {

	public int search2(int nums[], int target) {

		int len = nums.length;
		int low = 0, high = len - 1;

		int minIndex = findMin(nums, low, high);

		if (target == nums[minIndex])
			return minIndex;

		int rotated = minIndex;

		while (low <= high) {
			int mid = (low + high) / 2;

			int realMid = (mid + rotated) % len;

			if (nums[realMid] == target) {
				return realMid;
			}
			if (nums[realMid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public int findMin(int[] nums, int low, int high) {

		while (low < high) {
			int mid = (low + high) / 2;

			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	public int search(int nums[], int target) {

		int len = nums.length;

		int pivot = findMin(nums, 0, len - 1);

		// Array is not rotated - do a normal binary search
		if (pivot == -1) {
			return binarySearch(nums, 0, len - 1, target);
		}

		if (nums[pivot] == target)
			return pivot;

		if (nums[0] <= target)
			return binarySearch(nums, 0, pivot - 1, target);

		return binarySearch(nums, pivot + 1, len - 1, target);
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

		if (low > high)
			return -1;

		int mid = (low + high) / 2;

		if (nums[mid] == target)
			return mid;

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

		RotatedSortedArraySearch rotArrSearch = new RotatedSortedArraySearch();
		int arr[] = { 4, 5, 6, 7, 8, 0, 1, 2 };

		System.out.println(rotArrSearch.search(arr, 1));
		
		System.out.println(rotArrSearch.search2(arr, 1));

		int arr2[] = { 1, 2, 3 };
		System.out.println(rotArrSearch.search(arr2, 1));

		System.out.println(rotArrSearch.search(arr2, 0, arr2.length - 1, 1));
	}

}
