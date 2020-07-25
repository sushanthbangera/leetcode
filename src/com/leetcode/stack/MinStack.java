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
}
