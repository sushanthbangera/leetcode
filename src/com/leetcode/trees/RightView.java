package com.leetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class RightView {

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> resultList = new ArrayList<>();

		if (root == null)
			return resultList;

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();
			int i = 0;

			while (i++ < size) {
				TreeNode node = queue.remove();

				if (i == 1) {
					resultList.add(node.val);
				}

				if (node.right != null) {
					queue.add(node.right);
				}

				if (node.left != null) {
					queue.add(node.left);
				}
			}
		}
		return resultList;
	}
}
