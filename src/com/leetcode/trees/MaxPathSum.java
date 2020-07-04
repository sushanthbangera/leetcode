package com.leetcode.trees;

/*
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSum {

	private static int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		int val = calculatePathSum(root);
		return Math.max(val, max);
	}

	private int calculatePathSum(TreeNode root) {
		if (root == null)
			return 0;

		int leftSum = calculatePathSum(root.left);
		int rightSum = calculatePathSum(root.right);

		int maxBranch = Math.max(leftSum, rightSum);

		int strPathSum = Math.max(maxBranch + root.val, root.val);

		int maxStrPathRootSum = Math.max(leftSum + rightSum + root.val, strPathSum);

		max = Math.max(max, maxStrPathRootSum);

		return strPathSum;
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);

		tree.left = new TreeNode(2);
		tree.right = new TreeNode(10);

		tree.left.left = new TreeNode(-20);
		tree.left.right = new TreeNode(1);

		tree.right.right = new TreeNode(25);
		tree.right.right.left = new TreeNode(3);
		tree.right.right.right = new TreeNode(4);

		System.out.println("maximum path sum is : " + new MaxPathSum().maxPathSum(tree));
	}
}
