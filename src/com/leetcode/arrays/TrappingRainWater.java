package com.leetcode.arrays;

import java.util.Stack;

/*
 *  42. Trapping Rain Water
 *  https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

	/*
	 * Run time is 3 times the length of the array
	 * Time Complexity: O(n)
	   Space Complexity: O(n) - Two extra array is needed each of size n.
	 */
	public int getTrappedUnits(int[] height) {

		int n = height.length;

		if (n == 0) {
			return 0;
		}

		int left_max[] = new int[n];
		int right_max[] = new int[n];

		left_max[0] = height[0];

		for (int i = 1; i < n; i++) {
			left_max[i] = Math.max(left_max[i - 1], height[i]);
		}

		right_max[n - 1] = height[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			right_max[i] = Math.max(right_max[i + 1], height[i]);
		}
		
		int level = 0;

		for (int i = 0; i < n; i++) {
			level += Math.min(left_max[i], right_max[i]) - height[i];
		}

		return level;
	}
	
	/*
	 * Time complexity: O(n)
	 * Single iteration of O(n) in which each bar can be touched at most
	 * twice(due to insertion and deletion from stack) and insertion and 
	 * deletion from stack takes O(1) time.
	 * 
     * Space complexity: O(n). Stack can take upto O(n) space in case of stairs-like or flat structure.
	 */
	public int getTrappedUnits2(int[] height) {
		
		Stack<Integer> stack = new Stack<>();
	    int trappedLevel = 0;
	    int currentBuilding = 0;
	    
	    while (currentBuilding < height.length) {
	    	
	    	while (!stack.isEmpty() && height[currentBuilding] > height[stack.peek()]) {
	    		
	    		int top = stack.pop(); // previous building is smaller than current
	    		
	    		if (stack.isEmpty()) {
	    			break;
	    		}
	    		
	    		int distance = (currentBuilding - stack.peek()) - 1; // trapped between building
	    		
	    		int trappedHeight = Math.min(height[currentBuilding], height[stack.peek()]) - height[top];
	    		
	    		trappedLevel += distance * trappedHeight;
	    	}
	    	stack.push(currentBuilding++);
	    }
	    return trappedLevel;
	}

/*
 * Time: O(N)   Space: O(1)
 */
	public int getTrappedUnits3(int[] height) {
		int n = height.length;
		int left = 0, right = n - 1;
		int leftMax = 0, rightMax = 0;
		
		int level = 0;
		
		while (left < right) {
			
			if (height[left] < height[right]) {
				
				if (height[left] >= leftMax) {
					leftMax = height[left];
				} else {
					level += leftMax - height[left]; 
				}
				++left;
				
			} else {
				
				if (height[right] >= rightMax) {
					rightMax = height[right];
				} else {
					level+= rightMax - height[right];
				}
				--right;
			}
		}
		return level;
	}
}
