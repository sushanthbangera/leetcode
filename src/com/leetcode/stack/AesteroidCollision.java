package com.leetcode.stack;

import java.util.Stack;

/*
 * 735. Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision/
 */
public class AesteroidCollision {

	/*
	 * Time Complexity: O(n) since we iterate for all values in asteroids Space
	 * Complexity: O(n) since we use stack
	 */
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> asteroidStack = new Stack<>();
		int len = asteroids.length;

		for (int i = 0; i < len; i++) {

			if (asteroids[i] > 0) {
				asteroidStack.push(asteroids[i]);
			} else {
				while (!asteroidStack.isEmpty() && asteroidStack.peek() > 0
						&& asteroidStack.peek() < Math.abs(asteroids[i])) {
					asteroidStack.pop();
				}

				if (asteroidStack.isEmpty() || asteroidStack.peek() < 0) {
					asteroidStack.push(asteroids[i]);
				} else if (asteroidStack.peek() == Math.abs(asteroids[i])) {
					asteroidStack.pop();
				}
			}
		}

		int stackSize = asteroidStack.size();
		int res[] = new int[stackSize];
		for (int i = stackSize - 1; i >= 0; i--) {
			res[i] = asteroidStack.pop();
		}

		return res;
	}
}
