package com.leetcode.trees;

/*
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */
public class SameTreeCheck {

	/*
	 * Time: O(n) Space: O(h)
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		}

		return (p != null && q != null) && (p.val == q.val) && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}
}
