package com.leetcode.arrays;

import com.leetcode.utils.ArrayUtils;

/*
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

	/*
	 * Time: O(k * n) Space: O(1)
	 */
	public void rotate(int[] nums, int k) {
		int len = nums.length;

		k %= len;

		while (k-- > 0) {
			int temp = nums[len - 1];
			for (int i = len - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = temp;
		}
	}

	/*
	 * Time: O(n) Space: O(n)
	 */
	public void rotate2(int[] nums, int k) {
		int len = nums.length;
		int temp[] = new int[len];

		for (int i = 0; i < len; i++) {
			temp[(i + k) % len] = nums[i];
		}

		for (int i = 0; i < len; i++) {
			nums[i] = temp[i];
		}
	}

	/*
	 * Time: O(n) Space: O(1)
	 */
	public void rotate3(int[] nums, int k) {
		int len = nums.length;
		k %= len;

		reverse(nums, 0, len - 1); // 7, 6, 5, 4, 3, 2, 1
		reverse(nums, 0, k - 1); // 5, 6, 7, 4, 3, 2, 1
		reverse(nums, k, len - 1); // 7, 6, 5, 1, 2, 3, 4
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	/*
	 * Time: O(n) -> n elements are rotated 3 times. Space: O(1)
	 */
	public void rotate4(int[] nums, int k) {
		int len = nums.length;
		k %= len;
		int count = 0;

		for (int i = 0; count < len; i++) {
			int current = i;
			int prev = nums[current];

			do {
				int next = (current + k) % len;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count++;
				ArrayUtils.print(nums);
			} while (current != i);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		RotateArray ra = new RotateArray();
		ra.rotate4(arr, 3);
	}
}
