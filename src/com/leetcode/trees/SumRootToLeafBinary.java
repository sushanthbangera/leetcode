package com.leetcode.trees;

/*
 * 1022. Sum of Root To Leaf Binary Numbers
 * 
 */
public class SumRootToLeafBinary {

	private int result;

	/*
	 * Time: O(N) and Space: O(H)
	 */
	public int sumRootToLeaf(TreeNode root) {
		preorder(root, 0);
		return result;
	}

	private void preorder(TreeNode node, Integer curNumber) {

		if (node != null) {
			curNumber = (curNumber << 1) | node.val;

			if (node.left == null && node.right == null) {
				result += curNumber;
			}
			preorder(node.left, curNumber);
			preorder(node.right, curNumber);
		}
	}
}
