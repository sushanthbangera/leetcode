package com.leetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> resultList = new ArrayList<>();

		if (root == null)
			return resultList;

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();

			List<Integer> levelList = new ArrayList<>();
			resultList.add(levelList);

			while (size-- > 0) {

				TreeNode node = queue.poll();
				levelList.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return resultList;
	}
}
