package com.leetcode.arrays;

/*
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
public class MostWaterContainer {

	/*
	 * Time: O(n)
	 */
	public int maxArea(int[] height) {

		int len = height.length;
		int i = 0, j = len - 1;
		int max = Integer.MIN_VALUE;

		while (i < j) {
			int min = Math.min(height[i], height[j]);
			max = Math.max(max, min * (j - i));

			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println("Max Water: " + new MostWaterContainer().maxArea(height));
	}
}
