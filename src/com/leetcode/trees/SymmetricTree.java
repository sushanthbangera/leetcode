package com.leetcode.trees;

/*
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

	/*
	 * Time: O(n)  Space: O(n)
	 */
	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;

		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {

		if (leftNode == null && rightNode == null)
			return true;

		if (leftNode == null || rightNode == null)
			return false;

		return leftNode.val == rightNode.val && isMirror(leftNode.left, rightNode.right)
				&& isMirror(leftNode.right, rightNode.left);
	}
}
