package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/*
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if (root == null) {
			return paths;
		}
		dfs(root, "", paths);
		return paths;
	}

	private void dfs(TreeNode root, String path, List<String> paths) {

		path += root.val;

		if (root.left == null && root.right == null) {
			paths.add(path);
			return;
		}

		if (root.left != null) {
			dfs(root.left, (path + "->"), paths);
		}
		if (root.right != null) {
			dfs(root.right, (path + "->"), paths);
		}
	}
}
