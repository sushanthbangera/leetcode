package com.leetcode.trees;

/*
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class LeftLeavesSum {

	private Integer sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		inOrder(root, false);
		return sum;
	}

	private void inOrder(TreeNode root, boolean isLeft) {

		if (root == null)
			return;

		inOrder(root.left, true);

		if (isLeft && isLeafNode(root)) {
			sum = sum + root.val;
		}

		inOrder(root.right, false);
	}

	private boolean isLeafNode(TreeNode node) {
		return (node.left == null && node.right == null);
	}
}
