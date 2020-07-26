package com.leetcode.stack;

import java.util.Stack;

/*
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		int val = stack.pop();
		if (val == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	/*
	 * ------------- Using only on stack -----------
	 */

	int min = Integer.MAX_VALUE;
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push2(int x) {
		// push the old minimum value when the current
		// minimum value changes after with the new value x
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop2() {
		// if pop operation could result in the changing of the current minimum value,
		// pop twice and change the current minimum value to the last minimum value.
		if (stack.pop() == min)
			min = stack.pop();
	}

	public int top2() {
		return stack.peek();
	}

	public int getMin2() {
        return min;
	}
}
