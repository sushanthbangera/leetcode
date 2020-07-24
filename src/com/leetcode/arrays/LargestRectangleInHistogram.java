package com.leetcode.arrays;

import java.util.Stack;

public class LargestRectangleInHistogram {

	/*
	 * Time: O(N) Space: O(N)
	 */
	public int largestRectangleArea(int[] heights) {

		if (heights == null || heights.length == 0) {
			return 0;
		}

		int maxArea = 0;
		Stack<Integer> iStack = new Stack<>();
		Stack<Integer> hStack = new Stack<>();
		int lastWidth;

		for (int i = 0; i < heights.length; i++) {

			lastWidth = Integer.MAX_VALUE;

			while (!hStack.isEmpty() && hStack.peek() > heights[i]) {
				lastWidth = iStack.pop();
				int width = i - lastWidth;
				int height = hStack.pop();
				int curArea = width * height;
				maxArea = Math.max(maxArea, curArea);
			}

			if (hStack.isEmpty() || hStack.peek() < heights[i]) {
				lastWidth = Math.min(lastWidth, i);
				iStack.push(lastWidth);
				hStack.push(heights[i]);
			}
		}

		while (!hStack.isEmpty()) {
			int width = heights.length - iStack.pop();
			int height = hStack.pop();
			int curArea = width * height;
			maxArea = Math.max(maxArea, curArea);
		}

		return maxArea;
	}

	/*
	 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/
	 * 5ms-O(n)-Java-solution-explained-(beats-96)
	 */
	public int largestRectangleArea2(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
		int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
		lessFromRight[height.length - 1] = height.length;
		lessFromLeft[0] = -1;

		for (int i = 1; i < height.length; i++) {
			int p = i - 1;

			while (p >= 0 && height[p] >= height[i]) {
				p = lessFromLeft[p];
			}
			lessFromLeft[i] = p;
		}

		for (int i = height.length - 2; i >= 0; i--) {
			int p = i + 1;

			while (p < height.length && height[p] >= height[i]) {
				p = lessFromRight[p];
			}
			lessFromRight[i] = p;
		}

		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
		}

		return maxArea;
	}

	/*
	 * Tushar Roy
	 * https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/MaximumHistogram.java
	 */
	public int largestRectangleArea3(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> iStack = new Stack<>();
		int maxArea = 0;
		int curArea = 0;
		int i = 0;

		while (i < height.length) {

			if (iStack.isEmpty() || height[iStack.peek()] <= height[i]) {
				iStack.push(i++);
			} else {

				int top = iStack.pop();

				if (iStack.isEmpty()) {
					curArea = height[top] * i;
				} else {
					curArea = height[top] * (i - iStack.peek() - 1);
				}
			}

			if (curArea > maxArea) {
				maxArea = curArea;
			}

		}

		while (!iStack.isEmpty()) {
			int top = iStack.pop();

			if (iStack.isEmpty()) {
				curArea = height[top] * i;
			} else {
				curArea = height[top] * (i - iStack.peek() - 1);
			}
			if (curArea > maxArea) {
				maxArea = curArea;
			}
		}
		return maxArea;

	}
	
	
	public static void main(String[] args) {
		
		int height[] = {1, 2, 2, 1, 3, 4, 1, 2};
		LargestRectangleInHistogram lRect = new  LargestRectangleInHistogram();
		System.out.println(lRect.largestRectangleArea(height));
		System.out.println(lRect.largestRectangleArea2(height));
		System.out.println(lRect.largestRectangleArea3(height));
		
	}
}
