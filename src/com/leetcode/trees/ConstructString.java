package com.leetcode.trees;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * 606. Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class ConstructString {

	/*
	 * Time: O(N) and Space: O(N)
	 */
	public String tree2str(TreeNode t) {

		if (t == null) {
			return "";
		}

		if (t.left == null && t.right == null) {
			return t.val + "";
		}

		if (t.right == null) {
			return t.val + "(" + tree2str(t.left) + ")";
		}

		return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
	}

	/*
	 * Iterative traverse Time: O(N) and Space: O(N)
	 */
	public String treeString(TreeNode t) {

		if (t == null)
			return null;

		StringBuilder s = new StringBuilder();
		Stack<TreeNode> stack = new Stack<>();

		Set<TreeNode> visited = new HashSet<>();

		stack.push(t);

		while (!stack.isEmpty()) {

			TreeNode node = stack.peek();

			if (t.left == null && t.right == null) {
				s.append("()");
			}

			if (visited.contains(node)) {
				stack.pop();
				s.append(")");
			} else {
				visited.add(node);
				s.append("(" + node.val);

				if (node.right != null) {
					stack.push(node.right);
				}

				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}

		return s.substring(1, s.length() - 1);
	}

	public static void main(String[] args) {
		ConstructString cs = new ConstructString();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);

		System.out.println(cs.tree2str(root));
		System.out.println(cs.treeString(root));

	}
}
