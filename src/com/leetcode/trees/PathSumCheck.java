package com.leetcode.trees;

/*
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/
 */
public class PathSumCheck {

	/*
	 * Time: O(n) Space: O(h)
	 */
	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) {
			return false;
		}

		sum = sum - root.val;

		if (root.left == null && root.right == null && sum == 0) {
			return true;
		}

		boolean left = hasPathSum(root.left, sum);
		boolean right = hasPathSum(root.right, sum);

		return left || right;
	}

}
