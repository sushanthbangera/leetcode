package com.leetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		// Store each level elements list in a stack and finally add it to resultList
		Stack<List<Integer>> resultStack = new Stack<>();
		List<List<Integer>> resultList = new ArrayList<>();

		if (root == null)
			return resultList;

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();

			List<Integer> levelList = new ArrayList<>();
			resultStack.push(levelList);

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

		while (!resultStack.isEmpty()) {
			resultList.add(resultStack.pop());
		}
		
		return resultList;
	}
}
