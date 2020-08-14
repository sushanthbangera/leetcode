package com.leetcode.trees.pathsum;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.trees.TreeNode;

public class KSumPath {

	private int count = 0;

	public int pathSum(TreeNode root, int sum) {
		List<Integer> list = new ArrayList<>();
		KPathUtil(root, sum, list);
		return count;
	}

	private void KPathUtil(TreeNode root, int k, List<Integer> path) {
		// empty node
		if (root == null)
			return;

		// add current node to the path
		path.add(root.val);

		KPathUtil(root.left, k, path);
		KPathUtil(root.right, k, path);

		// check if there's any k sum path that
		// terminates at this node
		// Traverse the entire path as
		// there can be negative elements too
		int pathSum = 0;
		for (int j = path.size() - 1; j >= 0; j--) {
			pathSum += path.get(j);

			if (pathSum == k) {
				count++;
			}
		}

		// Remove the current element from the path
		path.remove(path.size() - 1);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);

		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);

		int k = 8;
		new KSumPath().pathSum(root, k);
	}
}
