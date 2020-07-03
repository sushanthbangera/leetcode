package com.leetcode.stack;

import java.util.Stack;

/*
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */
public class VaildParentheses {

	/*
	 * Time: O(n) Space: O(n) for stack
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
				continue;
			}

			if (stack.isEmpty())
				return false;

			switch (c) {
			case ')':
				if (stack.pop() != '(') {
					return false;
				}
				break;
			case '}':
				if (stack.pop() != '{') {
					return false;
				}
				break;
			case ']':
				if (stack.pop() != '[') {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}
}
