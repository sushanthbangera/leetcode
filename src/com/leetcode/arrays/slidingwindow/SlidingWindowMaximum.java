package com.leetcode.arrays.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

	/*
	 * Time limit exceeded in Leetcode Time: O(N^2) Space: O(N)
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return null;

		int n = nums.length;

		int max[] = new int[n - k + 1];

		for (int i = 0; i <= n - k; i++) {

			max[i] = nums[i];

			for (int j = i + 1; j < i + k; j++) {

				max[i] = Math.max(max[i], nums[j]);
			}
		}
		return max;
	}

	/*
	 * Time: O(N) and Auxilary Space: O(k)
	 */
	public int[] maxSlidingWindow2(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return null;

		/*
		 * Create a Double Ended Queue, that will store indexes of array elements The
		 * queue will store indexes of useful elements in every window and it will
		 * maintain decreasing order of values from front to rear in dq, i.e.,
		 * arr[dq.front[]] to arr[dq.rear()] are sorted in decreasing order
		 */
		Deque<Integer> dq = new LinkedList<>();
		int n = nums.length;
		int max[] = new int[n - k + 1];

		int maxPos = 0;
		int i;

		for (i = 0; i < k; i++) {

			// For every element, the previous smaller elements are useless so
			// remove them from dq
			while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}

		while (i < n) {
			// The element at the front of the queue is the largest element of
			// previous window
			max[maxPos++] = nums[dq.peek()];

			// Remove the elements which are out of this window
			while (!dq.isEmpty() && dq.peek() <= i - k) {
				dq.removeFirst();
			}
			// For every element, the previous smaller elements are useless so
			// remove them from dq
			while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
			i++;
		}
		// add the maximum element of last window
		max[maxPos] = nums[dq.peek()];
		return max;
	}

}
