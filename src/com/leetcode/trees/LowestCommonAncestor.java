package com.leetcode.trees;

/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

	/*
	 * Time: O(n) - all nodes are visited at worst case
	 * Space: O(h) - for the recursion stack 
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;

		if (root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);

		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}
}
