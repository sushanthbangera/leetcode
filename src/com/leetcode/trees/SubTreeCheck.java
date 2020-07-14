package com.leetcode.trees;

/*
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubTreeCheck {

	/*
	 * Time: O(m*n) - worst case of skewed tree
	 * Space: O(n) - Depth of recursion tree can go upto n
	 */
	public boolean isSubtree(TreeNode s, TreeNode t) {

		if (t == null)
			return true;

		if (s == null)
			return false;

		if (isIdentical(s, t)) {
			return true;
		}

		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isIdentical(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;

		if (s != null && t != null) {
			return s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
		}

		return false;
	}
}
