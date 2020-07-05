package com.leetcode.trees;

/*
 * 993. Cousins in Binary Tree
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class CousinsCheck {

	public boolean isCousins(TreeNode root, int x, int y) {

		if (root == null)
			return false;

		return (level(root, 0, x) == level(root, 0, y)) && !isSiblings(root, x, y);
	}

	private int level(TreeNode root, int height, int nodeVal) {
		if (root == null)
			return Integer.MIN_VALUE;

		if (root.val == nodeVal)
			return height;

		int left = level(root.left, height + 1, nodeVal);

		int right = level(root.right, height + 1, nodeVal);

		return Math.max(left, right);
	}

	private boolean isSiblings(TreeNode root, int x, int y) {

		if (root == null)
			return false;

		int left = root.left != null ? root.left.val : 0;
		int right = root.right != null ? root.right.val : 0;

		return (left == x && right == y) || (left == y && right == x) || isSiblings(root.left, x, y)
				|| isSiblings(root.right, x, y);
	}
}
