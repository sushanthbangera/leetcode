package com.leetcode.trees;

/*
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

	/*
	 * Time: O(N) Space: O(N)
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		Result result = new Result();
		sumLeftLeaves(root, result, false);
		return result.sum;
	}

	private void sumLeftLeaves(TreeNode node, Result result, boolean isLeft) {

		if (node == null)
			return;

		if (node.left == null && node.right == null && isLeft) {
			result.sum += node.val;
		}

		sumLeftLeaves(node.left, result, true);
		sumLeftLeaves(node.right, result, false);
	}

	public class Result {
		int sum;
	}
}
