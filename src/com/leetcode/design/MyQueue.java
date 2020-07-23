package com.leetcode.design;

import java.util.Stack;

/*
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class MyQueue {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	private int front;

	/** Initialize your data structure here. */
	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		front = -1;
	}

	/*
	 * Push with O(1) and pop Amortized O(1) and worst case O(N)
	 */
	/** Push element x to the back of queue. */
	public void push(int x) {
		if (stack1.empty())
			front = x;
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (!stack2.isEmpty()) {
			return stack2.peek();
		}
		return front;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	
	/*
	 *  -------- Push with O(N) and pop O(1) -------
	 */
	public void push2(int x) {
		if (stack1.empty()) {
			front = x;
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(x);
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
	
	public int pop2() {
		int ele = stack1.pop();
		if (!stack1.isEmpty()) {
			front = stack1.peek();
		}
		return ele;
	}
}
