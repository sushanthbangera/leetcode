package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class MyQStack {

	private Queue<Integer> queue1;
	private Queue<Integer> queue2;
	private int top;

	/** Initialize your data structure here. */
	public MyQStack() {
		queue1 = new LinkedList<>();
		queue2 = new LinkedList<>();
	}

	/*
	 * ---------------------------- push in O(1) and pop in O(N) --------
	 * 
	 */
	/** Push element x onto stack. O(1)*/ 
	public void push(int x) {
		queue1.add(x);
		top = x;
	}

	/** Removes the element on top of the stack and returns that element. */
	// O(N)
	public int pop() {
		if (empty()) {
			return -1;
		}
		int element = -1;
		while (queue1.size() > 1) {
			element = queue1.remove();
			queue2.add(element);
		}
		element = queue1.remove();
		Queue<Integer> temp = queue1;
		queue1 = queue2;
		queue2 = temp;
		return element;
	}

	/** Get the top element. */
	public int top() {
		if (empty()) {
			return -1;
		}
		return top;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue1.isEmpty();
	}
	
	/*
	 * ---------------------------- push in O(N) and pop in O(1) --------
	 * 
	 */
	/** Push element x onto stack. O(1)*/ 
	public void push2(int x) {
		queue2.add(x);
		top = x;
		while (!queue1.isEmpty()) {
			queue2.add(queue1.remove());
			Queue<Integer> temp = queue1;
			queue1 = queue2;
			queue2 = temp;
		}
	}
	
	public int pop2() {
		if (!queue1.isEmpty()) {
			return queue1.remove();
		}
		return -1;
	}
	
	/*
	 * ------------------------Using one Queue push in O(N) and pop in O(1) --------
	 * 
	 */
	public void push3(int x) {
		queue1.add(x);
		top = x;
		
		int size = queue1.size();
		while (size > 1) {
			queue1.add(queue1.remove());
		}
	}
}
