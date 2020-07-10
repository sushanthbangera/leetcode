package com.leetcode.trees.pathsum;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.trees.TreeNode;

/*
 * 113. Path Sum II Medium
 * https://leetcode.com/problems/path-sum-ii/
 */
public class RootLeafPathSum {

	/*
	 *  Time: O(n) Space: O(n)
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> paths = new ArrayList<>();
		if (root == null) {
			return paths;
		}

		List<Integer> path = new ArrayList<>();
		pathSum(root, sum, path, paths);
		return paths;
	}

	private void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {

		path.add(root.val);

		if (root.left == null && root.right == null) {
			if (sum - root.val == 0) {
				paths.add(path);
			}
			return;
		}

		if (root.left != null) {
			pathSum(root.left, sum - root.val, new ArrayList<>(path), paths);
		}

		if (root.right != null) {
			pathSum(root.right, sum - root.val, new ArrayList<>(path), paths);
		}
	}
}
